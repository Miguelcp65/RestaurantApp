package com.example.restaurantapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.restaurantapp.databinding.ActivityMainBinding
import com.example.restaurantapp.databinding.ActivityProfileBinding
import kotlin.math.log

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val loggedUsername = i.extras?.getString("loggedUsername")

        if (loggedUsername == "" || loggedUsername == null) {
            Toast.makeText(applicationContext, "Name not Found", Toast.LENGTH_LONG).show()
        } else {
            binding.loggedUserName.setText(loggedUsername)
        }
        binding.buttonLogout.setOnClickListener {
            i.putExtra("username", binding.loggedUserName.text.toString())
            setResult(1, i)
            finish()
        }
        binding.buttonShop.setOnClickListener {
            val i = Intent(this, ShopActivity::class.java)
            startActivity(i)
        }
    }
}