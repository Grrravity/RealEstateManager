package com.openclassrooms.realestatemanager.viewModel

import android.content.Context
import com.openclassrooms.realestatemanager.controllers.repository.PropertyRepository
import com.openclassrooms.realestatemanager.dao.RealEstateDB
import java.util.concurrent.Executor
import java.util.concurrent.Executors

object DataInjection {

    object Injection {

        // DataSource provider
        private fun providePropertyDataSource(context: Context): PropertyRepository {
            val database: RealEstateDB = RealEstateDB.getInstance(context)
            return PropertyRepository(database.propertyDao())
        }

        // Executor
        private fun provideExecutor(): Executor {
            return Executors.newSingleThreadExecutor()
        }

        // Provider ViewModelFactory
        fun provideViewModelFactory(context: Context): ViewModelFactory {
            val dataSourceItem: PropertyRepository = providePropertyDataSource(context)

            val executor: Executor = provideExecutor()
            return ViewModelFactory(dataSourceItem, executor)
        }
    }
}