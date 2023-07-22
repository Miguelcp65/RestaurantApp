package com.example.restaurantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.restaurantapp.databinding.ActivityOrderDetailsBinding

class OrderDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = intent
        val coffe_amount = i.getStringExtra("coffe_amount").toString().toInt()
        val bread_amount = i.getStringExtra("bread_amount").toString().toInt()
        val chocolate_amount = i.getStringExtra("chocolate_amount").toString().toInt()
        val coffe_price = i.getDoubleExtra("coffe_price", 0.0).toDouble()
        val bread_price = i.getDoubleExtra("bread_price", 0.0).toDouble()
        val chocolate_price = i.getDoubleExtra("chocolate_price", 0.0).toDouble()


        val coffe_total = (coffe_amount * coffe_price);
        val bread_total = bread_amount * bread_price;
        val chocolate_total = chocolate_amount * chocolate_price;
        val total = coffe_total + bread_total + chocolate_total;

        var details = "Order Details: \n";

        if (coffe_total != 0.0) {
            details = details.plus("Coffee: $coffe_amount Price: $coffe_total €\n")
        }
        if (bread_total != 0.0) {
            details = details.plus("Bread: $bread_amount Price: $bread_total €\n")
        }
        if (chocolate_total != 0.0) {
            details = details.plus("Chocolate: $bread_amount Price: $chocolate_total €\n")
        }
        if (total != 0.0) {
            details = details.plus("Total: $total €")
        }

        binding.textDetails.setText(details)
    }
}