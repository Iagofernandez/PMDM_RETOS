package com.example.retosbotones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

const val INTERNET_REQUEST = 1
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnUrl.setOnClickListener{retoInternet()}
    }

    fun retoInternet(){
        val miIntent = Intent(this, InternetReto::class.java)
        startActivityForResult(miIntent, INTERNET_REQUEST)
    }
}
