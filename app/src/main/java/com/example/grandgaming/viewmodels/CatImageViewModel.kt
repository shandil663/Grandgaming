package com.example.grandgaming.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grandgaming.data.model.APIItemItem
import com.example.grandgaming.data.repository.CatRepository
import kotlinx.coroutines.launch

class CatImageViewModel(private val repository: CatRepository) : ViewModel() {

    private val _catImagesData = MutableLiveData<List<APIItemItem>>()
    val catimges = _catImagesData

    private val _errorState = MutableLiveData<String?>()
    val errorState = _errorState

    fun getImagesData() {
        viewModelScope.launch {
            try {
                val response = repository.getCatImages()
                if (response.isSuccessful) {
                    _catImagesData.value = response.body()
                    _errorState.value = null
                } else {
                    _errorState.value = "Error: ${response.code()} - ${response.message()}"
                }
            } catch (e: Exception) {
                _errorState.value = "Network error: ${e.message}"
                e.printStackTrace()
            }
        }
    }
}
