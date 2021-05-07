package com.aait.ilovemovies.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aait.ilovemovies.R
import com.aait.ilovemovies.ui.auth.AuthActivity
import com.aait.ilovemovies.ui.home.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, AuthActivity::class.java))
    }
}