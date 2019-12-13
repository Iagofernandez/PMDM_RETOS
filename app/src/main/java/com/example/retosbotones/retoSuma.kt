package com.example.retosbotones

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_reto_camara.*
import kotlinx.android.synthetic.main.activity_reto_suma.*
import kotlinx.android.synthetic.main.activity_reto_suma.btnSalir
import org.jetbrains.anko.toast

class retoSuma : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_suma)

        btnComprobar.setOnClickListener{comprobarText()}
        btnSalir.setOnClickListener{salir()}


    }
    //SE INDICA MEDIANTE CHECKBOX(LA MANERA MAS SENCILLA QUE ENCONTRE PARA COMPLETAR ESTE RETO)
    //TIENES DOS OPCIONES; AL MARCAR UNA CHECK SE CONVIERTE EN TRUE(LAS CHECK SON BOOLEAN)
    //SI LA CORRECTA ES TRUE Y LA OTRA ES FALSE SE DA POR BUENO
    fun comprobarText(){
        if(opcion1.isChecked==false&&opcion2.isChecked==true){
            toast("Acierto")

            val inf = 1
            val data = Intent()

            data.putExtra("inf", inf)
            setResult(Activity.RESULT_OK,data)
        }



            }
    fun salir(){
        finish()
    }
}
