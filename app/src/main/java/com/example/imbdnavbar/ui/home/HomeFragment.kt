package com.example.imbdnavbar.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imbdnavbar.R
import com.example.imbdnavbar.databinding.FragmentHomeBinding
import com.example.imbdnavbar.ui.home.models.MockData
import com.example.imbdnavbar.ui.home.recyclerView.MoviesAdapter
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val moviesList: RecyclerView = binding.bestMoviesRV
        val moviesAdapter = MoviesAdapter()
        moviesList.adapter = moviesAdapter

        moviesList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);

        val root: View = binding.root

        homeViewModel.text.observe(viewLifecycleOwner) {
            //textView.text = it
        }

        homeViewModel.data.observe(viewLifecycleOwner){
            moviesAdapter.movies = it
        }

        viewLifecycleOwner.lifecycleScope.launch {
            homeViewModel.call()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}