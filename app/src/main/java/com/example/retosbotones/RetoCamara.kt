package com.example.retosbotones

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_reto_camara.*
import kotlinx.android.synthetic.main.activity_reto_camara.btnCamara
import org.jetbrains.anko.toast

const val CAMERA_PERMISOS =1;
const val  PHOTO_PERMISSION = 1;
class RetoCamara : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reto_camara)


        //LO PRIMERO ES VER QUE PERMISOS SOBRE LA CAMARA TIENE NUESTRA APP
        btnSalir.setOnClickListener { salir() }
        btnCamara.setOnClickListener { camaraFoto() }


    }

    fun camaraFoto() {
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {


            toast("sin permisos")
            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.CAMERA),
                CAMERA_PERMISOS
            )
        } else {
            toast("Los permisos estan concedidos")

            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->

                takePictureIntent.resolveActivity(packageManager)?.also {

                    startActivityForResult(takePictureIntent, PHOTO_PERMISSION)

                }
            }
        }

    }

//ESTE METODO SIRVEPARA LA RECOFIDA DE LA FOTOGRAFIA
    //ASI PODEMOS CREAR UN RETO PARA MEDIANTE LA FOTO QUE RECOGEMOS
    //PARA ELLO RECORREREMOS BIT A BIT LA FOTO
    //COMO SE PUEDE HACER??

        @SuppressLint("MissingSuperCall")
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            if(requestCode== PHOTO_PERMISSION&&resultCode== Activity.RESULT_OK){


                //PORQUE SI SE PONEN !! DETRAS DE DATA FUNCIONAN
                //EL BITMAP NOS PERMITE ECORRER LOS BITS DE UNA MAGEN Y REALIZAR COMPROBACIONES
                val bits = data!!.extras!!.get("data") as Bitmap


                //ASIGNACION DE EL BIT MAP A LA IMAGENVIEW
                imagen.setImageBitmap(bits)

                //ACCEDIENDO A BITS DE LA IMAGEN
                val imagenPixel = bits.getPixel(bits.width , bits.height)


                val rojo = imagenPixel shr 32 and 0xff
                val azul = imagenPixel and 0xff
                val verde = imagenPixel shr 16 and 0xff

                if(rojo<100&&azul<60&&verde<60){
                    toast("Superado")

                    val intentF=1

                    val data = Intent()
                    data.putExtra("intentF", intentF)
                    setResult(Activity.RESULT_OK,data)
                }


            }
        }


    fun salir() {
        finish()
    }
}


