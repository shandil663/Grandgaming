package com.example.grandgaming.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.grandgaming.data.repository.CatRepository
import com.example.grandgaming.viewmodels.CatImageViewModel

class CatViewModelFactory(private val repository: CatRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CatImageViewModel(repository) as T
    }
}
