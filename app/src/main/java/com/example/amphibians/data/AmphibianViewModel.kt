package com.example.amphibians.data



import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians.AmphibianApplication
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class AmphibianViewModel(val repository: AmphibianRepository ): ViewModel() {
       var amphibianNetworkResponse: AmphibianNetworkResponse by mutableStateOf( AmphibianNetworkResponse.Loading)
       init{
           getAmphibianData()
       }

        fun getAmphibianData(){
             viewModelScope.launch{
                    amphibianNetworkResponse  =
                        try{
                            val amphibians = repository.getAmphibians()
                            AmphibianNetworkResponse.Success(amphibians)
                        }catch(e  : HttpException){
                            AmphibianNetworkResponse.Failure
                        }catch(e: IOException){
                            AmphibianNetworkResponse.Failure
                        }
             }
        }
        companion object{
            val factory : ViewModelProvider.Factory = viewModelFactory {
                initializer {
                    val application = (this[APPLICATION_KEY]) as AmphibianApplication
                    val repository = application.container.repository
                        //println("${repository.}")
                    AmphibianViewModel(repository)
                }
            }
        }

}