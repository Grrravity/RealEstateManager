package com.openclassrooms.realestatemanager.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.openclassrooms.realestatemanager.controllers.repository.PropertyRepository
import java.util.concurrent.Executor

// ViewModelFactory
class ViewModelFactory(
    private val propertyDataRepository: PropertyRepository,
    private val executor: Executor
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PropertyViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PropertyViewModel(
                propertyDataRepository,
                executor
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}