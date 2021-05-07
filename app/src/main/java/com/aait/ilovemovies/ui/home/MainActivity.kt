package com.aait.ilovemovies.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import com.aait.ilovemovies.R
import com.aait.ilovemovies.databinding.ActivityMainBinding
import com.infideap.drawerbehavior.AdvanceDrawerLayout

class MainActivity : AppCompatActivity(), DrawerLayout.DrawerListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var drawer: AdvanceDrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        drawer = binding.drawerLayout
        drawer.setViewScale(Gravity.LEFT, 0.7f)
        drawer.setRadius(Gravity.LEFT, resources.getDimension(R.dimen._18sdp))
        drawer.setViewElevation(Gravity.LEFT, 20f)
    }

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
        TODO("Not yet implemented")
    }

    override fun onDrawerOpened(drawerView: View) {
        TODO("Not yet implemented")
    }

    override fun onDrawerClosed(drawerView: View) {
        TODO("Not yet implemented")
    }

    override fun onDrawerStateChanged(newState: Int) {
        TODO("Not yet implemented")
    }
}