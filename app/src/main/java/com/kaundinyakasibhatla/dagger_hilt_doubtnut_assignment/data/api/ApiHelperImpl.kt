package com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.data.api

import com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.data.model.Movie
import com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.data.model.Results
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getMovies(): Response<Results<Movie>> = apiService.getMovies()

}