package com.openclassrooms.realestatemanager.dao

import android.database.Cursor
import com.openclassrooms.realestatemanager.model.Property
import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import androidx.sqlite.db.SupportSQLiteQuery

@Dao
interface PropertyDao {
    //// ---- FOR PROPERTIES ---- ////

    @Query("SELECT * from property")
    fun getAllProperties(): LiveData<List<Property>>

    @Query("SELECT * from property WHERE id = :propertyId")
    fun getProperty(propertyId:Long): LiveData<Property>

    @RawQuery(observedEntities = [Property::class])
    fun getPropertyByArgs(query: SupportSQLiteQuery) : LiveData<List<Property>>

    @Insert(onConflict = REPLACE)
    fun insertProperty(property: Property): Long

    @Update
    fun updateProperty(property: Property): Int

    @Query("DELETE FROM property WHERE id = :index")
    fun deleteProperty(index: Long)

    //// ---- FOR CONTENT PROVIDER ---- ////

    @Query("SELECT * FROM property WHERE id = :idProperty")
    fun getPropertyWithCursor(idProperty: Long): Cursor
}