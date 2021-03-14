package com.example.foto

import android.R.attr
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var foto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.foto = findViewById(R.id.foto)
        this.foto.setOnClickListener({tirarFoto(it)})

    }

    private fun tirarFoto(view: View){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 1 && resultCode == Activity.RESULT_OK){
            val extras: Bundle = attr.data.getExtras()
            val imagem: Bitmap = extras.get("data")
            this.foto.setImageBitmap(imagem)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}