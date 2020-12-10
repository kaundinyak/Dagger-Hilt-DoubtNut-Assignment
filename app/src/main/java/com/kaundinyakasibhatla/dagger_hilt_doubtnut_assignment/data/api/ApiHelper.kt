package com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.data.api

import com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.data.model.Movie
import com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.data.model.Results
import retrofit2.Response

interface ApiHelper {
    suspend fun  getMovies(): Response<Results<Movie>>
}