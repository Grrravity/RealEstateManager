package com.openclassrooms.realestatemanager.controllers.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.openclassrooms.realestatemanager.R
import com.openclassrooms.realestatemanager.viewModel.DataInjection
import com.openclassrooms.realestatemanager.viewModel.PropertyViewModel

class SplashScreen : AppCompatActivity() {
    private lateinit var propertyViewModel: PropertyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        deleteIfExist()
        Handler().postDelayed({
            startMain()
        }, 500)
    }

    private fun startMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        this.finish()
    }

    private fun deleteIfExist() {
        propertyViewModel = ViewModelProviders.of(
            this,
            this.let { DataInjection.Injection.provideViewModelFactory(it) }
        ).get(PropertyViewModel::class.java)
        Thread {
            propertyViewModel.deleteProperty(10000)
        }.start()
    }
}