package com.example.retosbotones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

const val INTERNET_REQUEST = 1
const val CAMARA_REQUEST = 1
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnurl.setOnClickListener{retoInternet()}
        btnCamara.setOnClickListener{retoCamara()}
    }
    //METODO QUE LE PERMITE AL BOTON ACTIVARSE; INDICANDOLE QUE LA PULSAARLO
    //DEBE SITUARSE EN LA ACTIVITY CORRESPODIENTE
    fun retoInternet(){
        val nuevoIntent = Intent(this, InternetReto::class.java)
        startActivityForResult(nuevoIntent, INTERNET_REQUEST)
    }
    //METODO QUE LE PERMITE AL BOTON ACTIVARSE, INDICANDOLE QUE AL PULSARLO
    //DEBE SITUARSE EN LA SCTIVITY CORRESPONDIENTE

    fun retoCamara(){
        val nuevoIntent = Intent( this, RetoCamara::class.java)
        startActivityForResult(nuevoIntent, CAMARA_REQUEST)

    }


}
