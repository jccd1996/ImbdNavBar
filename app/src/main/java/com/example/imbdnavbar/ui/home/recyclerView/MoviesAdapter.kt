package com.example.imbdnavbar.ui.home.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imbdnavbar.R
import com.example.imbdnavbar.domain.model.Results

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    var movies = listOf<Results>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val article = movies[position]
        holder.bind(article)
    }

    override fun getItemCount() = movies.size

    class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.titleTV)
        //val description: TextView = view.findViewById(R.id.article_description)
        //val image: ImageView = view.findViewById(R.id.featured_image)

        fun bind(article: Results) {
            title.text = article.title
         //   description.text = article.description
        //    image.setImageResource(article.featuredImage)
        }

    }
}