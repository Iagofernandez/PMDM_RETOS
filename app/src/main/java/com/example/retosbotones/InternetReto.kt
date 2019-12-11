package com.example.retosbotones

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_internet.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.toast

class InternetReto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        //PRUEBA DE RETO INTERNET
        //BUSCAR INFO SOBRE LA LUNA
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internet)

        //TOAST DE BIENVENIDA
        toast("reto de internet sobre la luna")

        //LSITENER PARA LOS BOTONES; ASI REALIZAN FUNCIONES AL SER CLICKEADOS
        btnBuscar.setOnClickListener{RespuestaCorrecta()}
        btnUrl.setOnClickListener{browse("https://es.wikipedia.org/wiki/Luna")}


    }

    fun RespuestaCorrecta(){
        if(textoRespuesta.text.toString()=="1737"){
            toast("correcto")

            val inf = 1
            val data = Intent()

            data.putExtra("inf ", inf)
            setResult(Activity.RESULT_OK, data)
        }else{
            toast("incorrecto")
            val inf2 = 0
            val data = Intent()

            data.putExtra("inf", inf2)
            setResult(Activity.RESULT_OK, data)
        }

    }
}
