package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

//creamos el objeto Moshi
//Moshi es una librería para parsear JSON en objetos Java o Kotlin
private val moshi = Moshi.Builder()
    //convertimos la respuesta json a objetos Kotlin con Moshi
    .add(KotlinJsonAdapterFactory())
    .build()

//usamos retrofit para consumir la appi
private val retrofit = Retrofit.Builder()
     //addConverterFactory se utiliza para serianlizar y deserializar objetos
     //Usamos MoshiConverterFactory Cree una instancia con moshi para la conversión
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//MarsApiserrvice define como Retrofit se communica con el servidor web con http
interface MarsApiService {
    //Le indicamos que realizara una solicitud Get al endpoint photos
    @GET("photos")
    //Obtenemso el String de respuesta
    suspend fun getPhotos() : List<MarsPhoto>

}

//definimos el objeto MarsApi singleton para inicializar el servicio
object MarsApi {
   val retrofitService : MarsApiService by lazy {
       //inicializamos la variable retrofit con el metodo create
       retrofit.create(MarsApiService::class.java)
   }
}