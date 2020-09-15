package com.openclassrooms.realestatemanager.controllers.activities;

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

import com.openclassrooms.realestatemanager.R
import android.Manifest
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        checkSelfPermission()
        configureToolbar()
        configureNavigationDrawer()
        configureNavigationView()
    }

    //Checking storage, location, phone sate and camera permissions
    private fun checkSelfPermission() {
        val permissions: ArrayList<String> = ArrayList()
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
        }
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_PHONE_STATE
            ) != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.READ_PHONE_STATE)
        }
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION)
        }
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.ACCESS_FINE_LOCATION)
        }
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.CAMERA)
        }
        if(permissions.isNotEmpty()) {
            val askPermissionsList: Array<String> = arrayOf()
            val array = arrayOfNulls<String>(permissions.size)
            askPermissionsList to array
            ActivityCompat.requestPermissions(
                this,
            permissions.toArray(askPermissionsList),
                1
            )
        }
    }

    //setting toolbar
    private fun configureToolbar() {
        setSupportActionBar(toolbar)
    }

    //setting navigation drawer
    private fun configureNavigationDrawer() {
        drawer = activity_main_drawer_layout
        toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_closed
        )
        drawer.addDrawerListener(toggle)
        supportActionBar?.setHomeButtonEnabled(true)
        toggle.isDrawerIndicatorEnabled = true
        toggle.syncState()
    }

    //Setting navigation drawer view
    private fun configureNavigationView() {
        val navigationView : NavigationView = nav_view
        navigationView.setNavigationItemSelectedListener(this)
    }

    //setting navigation on click actions
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.activity_main_drawer_simulator -> {
                //launchSimultor()
            }
            R.id.activity_main_drawer_create -> {
                //launchCreateActivity()
            }
            R.id.activity_main_drawer_search -> {
                //launchSearchFragment()
            }
            R.id.activity_main_drawer_preferences -> {
                //launchSettingsFragment()
            }
            R.id.activity_main_drawer_logout -> {
                //shoClosedApp()
            }
        }
        activity_main_drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

}
