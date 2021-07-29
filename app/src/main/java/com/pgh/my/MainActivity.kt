package com.pgh.my


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation


class MainActivity : AppCompatActivity(R.layout.activity_main) {
    lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController= Navigation.findNavController(this,R.id.nav_host)
    }

}