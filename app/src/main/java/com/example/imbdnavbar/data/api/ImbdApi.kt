
import com.example.imbdnavbar.domain.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ImbdApi {
    @GET("/3/movie/top_rated")
    suspend fun getMovies() : Response<MoviesResponse>
}
