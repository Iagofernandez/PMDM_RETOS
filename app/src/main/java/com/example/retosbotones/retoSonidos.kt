package com.example.retosbotones

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_reto_sonidos.*
import org.jetbrains.anko.toast

class retoSonidos : AppCompatActivity() {

    //EN ESTA PARTE SE CREA UNA VARIABLE QUE VA A ACCEDER A LA CARPETA  RAW QUE TUVE QUE CREAR

    val player: MediaPlayer? =  MediaPlayer.create(this@retoSonidos, R.raw.chicken_chick)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_sonidos)

        btnSonido.setOnClickListener{sonido()}
        btnComprobar.setOnClickListener{comprobar()}
        btnSalir.setOnClickListener{salir()}


    }
    fun sonido() {
        val button = findViewById<View>(R.id.btnSonido) as Button
        button.setOnClickListener {
            //ESTAS EXCLMACIONES VIENEN DADAS YA QUE ESTE PLAYER DEBE TENER UN VALOR NULL INICIAL
            //SI NO DA ERROR
            //PERO AL PONER ESTAS EXCLAMACIONES SALE EL EEROR
            //POR QUE? PREGUNTAR
            player!!.start()


        }
    }
    fun comprobar(){
        if(opcion1.isChecked==true&&opcion2.isChecked==false){
            toast("Correcto")
        }
    }
    fun salir(){
        finish()
    }
}
