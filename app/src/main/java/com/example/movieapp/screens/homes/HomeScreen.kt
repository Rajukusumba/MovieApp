package com.example.movieapp.screens.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.MovieRow
import com.example.movieapp.navigation.MovieScreens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeSreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Red, elevation = 10.dp) {
            Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {

                Text(text = "Movies", color = Color.Green)
            }


        }
    }) {
      MainContent(navController=navController)
    }


}
@Composable
fun MainContent(
    navController: NavController,
    moviesList: List<String> = listOf("Avathar", "300", "Bhahubali", "hsajdhjh")
) {
    Column(Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = moviesList) {
                MovieRow(movie = it){
                  //  Log.d("TAG", "MainContent:${it} ")
                    navController.navigate(route = MovieScreens.DetailScreen.name)
                }


            }
        }
    }

}
