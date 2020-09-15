package com.openclassrooms.realestatemanager.dao

import android.content.Context
import androidx.room.*
import com.openclassrooms.realestatemanager.model.Address
import com.openclassrooms.realestatemanager.model.Picture
import com.openclassrooms.realestatemanager.model.Property

// RealEstateManager Database configuration
@Database(entities = [(Property::class), (Picture::class), (Address::class)],version = 2, exportSchema = false)
abstract class RealEstateDB : RoomDatabase() {

    abstract fun propertyDao(): PropertyDao

    companion object {
        private var INSTANCE: RealEstateDB? = null

        fun getInstance(context: Context):RealEstateDB{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,RealEstateDB::class.java,"RealEstateManager.db").build()
                }
            }
            return INSTANCE as RealEstateDB
        }
    }
}