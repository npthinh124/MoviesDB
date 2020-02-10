package net.vinid.moviedb

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import net.vinid.moviedb.databinding.ActivityMainBinding
import net.vinid.moviedb.ui.base.BaseActivity
import net.vinid.moviedb.util.ext.setupWithNavController

class MainActivity : BaseActivity() {

    private var currentNavController: LiveData<NavController>? = null
    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }

    /**
     * show BottomNavigation
     */
    fun showBottomNavigation() {
        dataBinding.bottomNav.visibility = View.VISIBLE
    }

    /**
     * hide BottomNavigation
     */
    fun hideBottomNavigation() {
        dataBinding.bottomNav.visibility = View.GONE
    }

    /**
     * Called on first creation and when restoring state.
     */
    private fun setupBottomNavigationBar() {
        val navGraphIds = listOf(R.navigation.home_nav_graph, R.navigation.search_nav_graph, R.navigation.favorites_nav_graph)
        // Setup the bottom navigation view with a list of navigation graphs
        val controller = dataBinding.bottomNav.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )
        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }
}