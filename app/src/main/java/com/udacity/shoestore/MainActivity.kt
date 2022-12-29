package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import timber.log.Timber
import com.udacity.shoestore.databinding.ActivityMainBinding
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp

class MainActivity : AppCompatActivity() {

    //    Declaration of variables
    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //set binding object to inflate activity_main layout
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        //set Nav Host Fragment to use fragment in activity_main
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        //initialize Nav Controller
        navController = navHostFragment.findNavController()

        //set up navigation with AppBarConfiguration
        appBarConfiguration = AppBarConfiguration(navController.graph)

        //timber plugin for logging messages
        Timber.plant(Timber.DebugTree())

        //set up action bar to use Nav Controller and App Bar Configuration in this activity
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    //set up up arrow to navigate using back stack
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) ||
                super.onSupportNavigateUp()
    }
}
