package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.screens.home.HomeSreen
import com.example.movieapp.screens.home.details.DetailsScreen

@Composable
fun MovieNavigation(){
    val navController= rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreens.HomeScreen.name){
        composable(MovieScreens.HomeScreen.name){
            HomeSreen(navController = navController)
        }
        composable(MovieScreens.DetailScreen.name){
            DetailsScreen(navController = navController)
        }

    }

}