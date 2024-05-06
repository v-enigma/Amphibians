package com.example.amphibians.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.R
import com.example.amphibians.model.Amphibian

@Composable
fun AmphibianCard(amphibian: Amphibian){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp, pressedElevation = 1.dp)
    ){
          Text("${amphibian.name}  (${amphibian.type}) " , modifier = Modifier.padding(10.dp), fontWeight = FontWeight.Bold, fontSize = 20.sp)
          AsyncImage(
              model = ImageRequest.Builder(LocalContext.current).data(amphibian.img_src).build(),
               contentDescription = " ",
               placeholder = painterResource(R.drawable.loading_img) ,
               contentScale = ContentScale.Crop,
               error =  painterResource(id = R.drawable.baseline_broken_image_24),
              modifier = Modifier.fillMaxWidth()
          )
          Text( text = amphibian.description , modifier = Modifier.padding(5.dp))

    }

}

@Composable
fun SuccessScreen(modifier: Modifier, amphibians : List<Amphibian>){
    Scaffold(topBar = { Text(stringResource(id = R.string.app_name), fontSize = 24.sp, fontWeight = FontWeight.Bold , modifier = Modifier.padding(top =5.dp))}){
        LazyColumn(modifier = modifier.padding(it)){
            items(amphibians){
                Spacer(modifier =Modifier.height(25.dp))
                AmphibianCard(amphibian = it)
            }
        }
    }

}



@Composable
fun ErrorScreen(onClick:()-> Unit){
    Box{
           Image(painterResource(id = R.drawable.baseline_cloud_off_24)," ")
           Text("Failed to Load")
           Button(onClick = onClick){
                 Text(" Reload")
           }

    }
}


@Composable
fun LoadingScreen(){
        Box(modifier = Modifier){
             Image( painterResource(id = R.drawable.loading_img), " ")
        }
}
