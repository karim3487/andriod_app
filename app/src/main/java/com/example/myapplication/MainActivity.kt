package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val bSignIn : Button = findViewById(R.id.b_singIn)
        bSignIn.setOnClickListener {
            val intent = Intent(this@MainActivity, NewsActivity::class.java)
            startActivity(intent)
        }
    }

}