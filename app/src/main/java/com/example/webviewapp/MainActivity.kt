package com.example.webviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.webviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var num = 0
        num = 1 + 1
        println(num)
    }
}