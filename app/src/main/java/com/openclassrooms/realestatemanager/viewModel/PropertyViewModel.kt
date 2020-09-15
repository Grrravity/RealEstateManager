package com.openclassrooms.realestatemanager.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.sqlite.db.SimpleSQLiteQuery
import com.openclassrooms.realestatemanager.controllers.repository.PropertyRepository
import com.openclassrooms.realestatemanager.model.Property
import java.util.concurrent.Executor

class PropertyViewModel(private val mPropertyRepository: PropertyRepository,
                        private val executor: Executor
): ViewModel(){
///// --- PROPERTY --- /////

    // --- GET ---
    fun getAllProperty(): LiveData<List<Property>> {
        return mPropertyRepository.getProperties()
    }
    fun getProperty(propertyId: Long): LiveData<Property> {
        return mPropertyRepository.getProperty(propertyId)
    }
    // --- CREATE ---
    fun createProperty(property: Property?) {
        executor.execute { mPropertyRepository.createProperty(property) }
    }

    // --- UPDATE ---
    fun updateProperty(property: Property?) {
        executor.execute { mPropertyRepository.updateProperty(property) }
    }

    // --- DELETE ---
    fun deleteProperty(propertyId: Long) {
        mPropertyRepository.deleteProperty(propertyId)
    }

    //// --- SEARCH --- ////
    fun getPropertyByArgs(queryString:String) : LiveData<List<Property>>{
        val query = SimpleSQLiteQuery(queryString)
        Log.e("getting prop with args","Query : ${query.sql}")
        return mPropertyRepository.getPropertyByArgs(query)
    }
}