package com.example.amphibians.data

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibianNetworkService


interface AmphibianRepository {
   suspend fun getAmphibians(): List<Amphibian>
}

class DefaultRepository(private val  retrofitService: AmphibianNetworkService): AmphibianRepository{
      override suspend fun getAmphibians():List<Amphibian>{
        return retrofitService.getData()
      }
}