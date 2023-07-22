package com.example.restaurantapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class ShopSplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            val i = intent
            val j = Intent(this, OrderDetailsActivity::class.java)
            j.putExtras(i)
            startActivity(j)
        }, 1000)
    }
}