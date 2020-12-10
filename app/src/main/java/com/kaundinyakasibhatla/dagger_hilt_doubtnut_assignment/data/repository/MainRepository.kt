package com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.data.repository

import com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getMovies() =  apiHelper.getMovies()

}