package com.openclassrooms.realestatemanager.controllers.repository

import androidx.lifecycle.LiveData
import androidx.sqlite.db.SimpleSQLiteQuery
import com.openclassrooms.realestatemanager.dao.PropertyDao
import com.openclassrooms.realestatemanager.model.Property

class PropertyRepository(private val propertyDao: PropertyDao) {
    // --- GET ---
    fun getProperty(id: Long): LiveData<Property> {
        return propertyDao.getProperty(id)
    }
    fun getProperties(): LiveData<List<Property>> {
        return propertyDao.getAllProperties()
    }

    fun getPropertyByArgs(query: SimpleSQLiteQuery) : LiveData<List<Property>>{
        return propertyDao.getPropertyByArgs(query)
    }

    // --- CREATE ---
    fun createProperty(property: Property?) {
        propertyDao.insertProperty(property!!)
    }

    // --- UPDATE ---
    fun updateProperty(property: Property?) {
        propertyDao.updateProperty(property!!)
    }

    // --- DELETE ---
    fun deleteProperty(l: Long) {
        propertyDao.deleteProperty(l)
    }
}