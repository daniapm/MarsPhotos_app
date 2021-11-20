package com.example.android.marsphotos

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load

//BindingAdapter se utiliza para tener configuradores personalizados
// para alguna propiedad de sus vistas
@BindingAdapter("imageUrl")
fun bindImage (imgView: ImageView, imgUrl : String?) {
    imgUrl?.let {
        //Convertimos la cadena Url en Uri objeto
        //con toUri()
        //con buildUpon.scheme("https") usamos el esquema HTTPS
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        //Cargamos la imagen con Coil destro de el objeto Imgview
        imgView.load(imgUri){
            placeholder(R.drawable.loading_animation)
            error((R.drawable.ic_broken_image))

        }
    }
}
