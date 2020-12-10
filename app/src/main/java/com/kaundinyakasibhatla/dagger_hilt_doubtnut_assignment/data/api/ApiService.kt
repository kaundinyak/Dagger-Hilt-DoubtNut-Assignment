package com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.data.api


import com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.data.model.Movie
import com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.data.model.Results
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("top_rated?api_key=a25ce43e6be097920669eb282da03464&language=en-US&page=1/")
    suspend fun getMovies(): Response<Results<Movie>>

}