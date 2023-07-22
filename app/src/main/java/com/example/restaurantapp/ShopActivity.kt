package com.example.restaurantapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.restaurantapp.databinding.ActivityShopBinding

class ShopActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShopBinding
    private val priceBread = 1.5
    private val priceCoffe = 1.0
    private val priceChocolate = 2.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShopBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOrder.setOnClickListener {
            val i = Intent(this, ShopSplashScreenActivity::class.java)
            i.putExtra("coffe_amount", binding.editAmountCoffe.text.toString())
            i.putExtra("bread_amount", binding.editAmountBread.text.toString())
            i.putExtra("chocolate_amount", binding.editAmountChocolate.text.toString())
            i.putExtra("coffe_price", priceCoffe)
            i.putExtra("bread_price", priceBread)
            i.putExtra("chocolate_price", priceChocolate)
            startActivity(i)
        }

        binding.checkCoffe.setOnClickListener {
            if (binding.checkCoffe.isChecked()) {
                binding.editAmountCoffe.setText("1")
                binding.textPriceCoffe.visibility = View.VISIBLE
            } else {
                binding.editAmountCoffe.setText("0")
                binding.textPriceCoffe.visibility = View.GONE
            }
        }

        binding.checkBread.setOnClickListener {
            if (binding.checkBread.isChecked()) {
                binding.editAmountBread.setText("1")
                binding.textPriceBread.visibility = View.VISIBLE
            } else {
                binding.editAmountBread.setText("0")
                binding.textPriceBread.visibility = View.GONE
            }
        }

        binding.checkChocolate.setOnClickListener {
            if (binding.checkChocolate.isChecked()) {
                binding.editAmountChocolate.setText("1")
                binding.textPriceChocolate.visibility = View.VISIBLE
            } else {
                binding.editAmountChocolate.setText("0")
                binding.textPriceChocolate.visibility = View.GONE
            }
        }
    }

}