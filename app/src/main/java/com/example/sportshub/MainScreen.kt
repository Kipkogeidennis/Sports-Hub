package com.example.sportshub

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sportshub.SignInActivity
import com.example.sportshub.databinding.ActivityMainScreenBinding

class MainScreen : AppCompatActivity() {

    private lateinit var binding: ActivityMainScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //handle login click
        binding.loginBtn.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))

        }

        binding.skipBtn.setOnClickListener {

            startActivity(Intent(this, DashBoardUser::class.java))
        }
    }

}