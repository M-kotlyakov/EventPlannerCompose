package com.example.eventerplanner.ui

import android.os.Bundle
import android.view.View
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigator
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.eventerplanner.R
import com.example.eventerplanner.ui.bottomTabs.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private var isHomeScreenVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        val component = (application as App).component
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHost: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.main_nav_host_fragment) as NavHostFragment ?: return

        val navController = navHost.navController
        setupBottomNavView(navController)
    }


    private fun setupBottomNavView(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        bottomNav?.setupWithNavController(navController)
        navController.addOnDestinationChangedListener {_, destination, _ ->
            if (destination.id == R.id.firstFragment
                || destination.id == R.id.signInFragment
                || destination.id == R.id.signUpFragment) {
                bottomNav.visibility = View.GONE
            } else {
                bottomNav.visibility = View.VISIBLE
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    internal fun setHomeScreenVisible(visible: Boolean) {
        isHomeScreenVisible = visible
    }
}
