package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val btn_click_me = findViewById(R.id.b_singIn) as Button
        btn_click_me.setOnClickListener {
            val intent = Intent(this@MainActivity, NewsActivity::class.java)
            startActivity(intent)
        }
    }

}