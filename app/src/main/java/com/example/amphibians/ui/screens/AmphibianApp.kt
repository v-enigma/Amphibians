package com.example.amphibians.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.data.AmphibianNetworkResponse
import com.example.amphibians.data.AmphibianViewModel

@Composable
fun AmphibianApp(modifier: Modifier){
    val viewModel : AmphibianViewModel = viewModel( factory = AmphibianViewModel.factory )
    when(val networkResponse = viewModel.amphibianNetworkResponse){
        is AmphibianNetworkResponse.Success -> SuccessScreen( modifier = modifier.fillMaxSize(),amphibians = networkResponse.amphibians )
        is AmphibianNetworkResponse.Failure -> ErrorScreen( onClick = { viewModel.getAmphibianData() } )
        is AmphibianNetworkResponse.Loading -> LoadingScreen()
    }
}