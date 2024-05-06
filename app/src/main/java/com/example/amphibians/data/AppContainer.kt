package com.example.amphibians.data

import com.example.amphibians.network.AmphibianNetworkService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
        val repository: AmphibianRepository
}

class DefaultContainer: AppContainer{
        private val baseURL = "https://android-kotlin-fun-mars-server.appspot.com"
        val retrofit : Retrofit = Retrofit.Builder()
                .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
                .baseUrl(baseURL)
                .build()
        private val retrofitService : AmphibianNetworkService by lazy{ retrofit.create(AmphibianNetworkService::class.java) }
        override val repository: AmphibianRepository by lazy{  DefaultRepository(retrofitService)}

}