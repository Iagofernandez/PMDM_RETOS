package com.example.retosbotones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_reto_camara.*
import kotlinx.android.synthetic.main.activity_reto_suma.*
import kotlinx.android.synthetic.main.activity_reto_suma.btnSalir

class retoSuma : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_suma)

        btnComprobar.setOnClickListener{comprobarText()}
        btnSalir.setOnClickListener{salir()}


    }
    fun comprobarText(){



            }
    }
}
