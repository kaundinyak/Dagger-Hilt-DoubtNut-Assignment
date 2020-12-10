package com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.ui.home.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.data.model.Movie
import com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.data.model.Results
import com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.data.repository.MainRepository
import com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.utils.NetworkHelper
import com.kaundinyakasibhatla.dagger_hilt_doubtnut_assignment.utils.Resource
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _movies = MutableLiveData<Resource<List<Movie>>>()
    val movies: LiveData<Resource<List<Movie>>>
        get() = _movies

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            _movies.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getMovies().let { response ->
                    if (response.isSuccessful) {
                        response.body()?.let {
                            _movies.postValue(Resource.success((it.results)))
                        } ?: run {
                            _movies.postValue(Resource.error(response.errorBody().toString(), null))
                        }

                    } else {
                        _movies.postValue(Resource.error(response.errorBody().toString(), null))
                    }
                }
            } else _movies.postValue(Resource.error("No internet connection", null))
        }
    }
}