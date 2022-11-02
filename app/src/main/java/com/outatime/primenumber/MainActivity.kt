package com.outatime.primenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.outatime.primenumber.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun click(view: View) {
        if(binding.etNumber.text.isNotEmpty()){
            val number = binding.etNumber.text.toString().toInt()

            if(isItPrime(number)){
                binding.tvResult.text = getString(R.string.it_is_prime, number)
            } else {
                binding.tvResult.text = getString(R.string.it_is_not_prime, number)
            }

        } else {
            Toast.makeText(this@MainActivity, getString(R.string.toast_required_value), Toast.LENGTH_SHORT)
            binding.etNumber.error = getString(R.string.required_value)
        }
    }

    //Algorithm to verify if a number is prime or not
    fun isItPrime(number: Int): Boolean {
        if(number <= 1) return false

        for(i in 2 until number){
            if(number % i == 0) return false
        }

        return true
    }
}