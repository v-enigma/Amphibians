package com.example.amphibians.data

import com.example.amphibians.model.Amphibian

sealed interface AmphibianNetworkResponse {
    class Success(val amphibians:List<Amphibian>): AmphibianNetworkResponse
    data object Failure : AmphibianNetworkResponse
    data object Loading: AmphibianNetworkResponse

}