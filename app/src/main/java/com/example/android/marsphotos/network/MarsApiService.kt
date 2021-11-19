package com.example.android.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

//MarsApiserrvice define como Retrofit se communica con el servidor web con http
interface MarsApiService {
    //Le indicamos que realizara una solicitud Get al endpoint photos
    @GET("photos")
    //Obtenemso el String de respuesta
    fun getPhotos() {

    }

}

//definimos el objeto MarsApi singleton para inicializar el servicio
object MarsApi {
   val retrofitService : MarsApiService by lazy {
       //inicializamos la variable retrofit con el metodo create
       retrofit.create(MarsApiService::class.java)
   }
}