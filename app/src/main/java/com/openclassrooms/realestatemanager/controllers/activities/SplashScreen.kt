package com.openclassrooms.realestatemanager.controllers.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.openclassrooms.realestatemanager.R

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        deletIfAlreadyExist()
        Handler().postDelayed({
            launchMain()
        }, 500)
    }

    private fun launchMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        this.finish()
    }

    private fun deletIfAlreadyExist() {
        TODO("Not yet implemented")
    }
}