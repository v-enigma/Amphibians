package com.example.amphibians.network

import com.example.amphibians.model.Amphibian
import retrofit2.http.GET



interface AmphibianNetworkService{

    @GET("amphibians")
    suspend fun getData() : List<Amphibian>

}