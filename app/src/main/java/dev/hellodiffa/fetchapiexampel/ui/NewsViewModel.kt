package dev.hellodiffa.fetchapiexampel.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.hellodiffa.fetchapiexampel.NewsApp
import dev.hellodiffa.fetchapiexampel.common.Constant
import dev.hellodiffa.fetchapiexampel.common.ResultState
import dev.hellodiffa.fetchapiexampel.model.NewsResponse
import dev.hellodiffa.fetchapiexampel.remote.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel : ViewModel() {

    private val apiService : ApiService by lazy {
        NewsApp.api
    }

    private val _news = MutableLiveData<ResultState<NewsResponse>>()
    val news : LiveData<ResultState<NewsResponse>> get() = _news

    init {
        viewModelScope.launch {
            _news.postValue(ResultState.loading())
            delay(1_500)
            try {
                val data = withContext(Dispatchers.IO){
                    apiService.getAllArticle(Constant.SOURCES, Constant.API_KEY)
                }
                _news.postValue(ResultState.success(data))
            }catch (e : Exception){
                _news.postValue(ResultState.error(e.message.toString()))
            }

        }

    }

}