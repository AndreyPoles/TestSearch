package com.search.searchimages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.search.searchimages.model.Images
import com.search.searchimages.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Images> = MutableLiveData()

    fun getPost(tag: String) {
        viewModelScope.launch {
            val response: Images = repository.getPost(tag)
            myResponse.value = response
        }
    }
}