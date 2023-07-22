package com.example.restaurantapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBar
import com.example.restaurantapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var result: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            if (username == "user" && password == "pass") {
                Toast.makeText(applicationContext, "Logged In", Toast.LENGTH_LONG).show()
                val i = Intent(this, ProfileActivity::class.java)
                i.putExtra("loggedUsername", username)
                result.launch(i)
            } else {
                Toast.makeText(applicationContext, "Invalid Login", Toast.LENGTH_LONG).show()
            }
            binding.editUsername.setText("")
            binding.editPassword.setText("")
        }
        result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.data != null && it.resultCode == 1) {
                val prevUsername = it.data?.getStringExtra("username").toString()
                binding.editUsername.setText(prevUsername)
            } else {
                Toast.makeText(applicationContext, "Erro no Username", Toast.LENGTH_LONG).show()
            }
        }
    }
}