package com.example.movieapp

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MovableContent
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.navigation.MovieNavigation
import com.example.movieapp.ui.theme.MovieAppTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
         MovieNavigation()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyApp(content: @Composable () -> Unit) {
    MovieAppTheme {
//        Scaffold(topBar = {
//            TopAppBar(backgroundColor = Color.Red, elevation = 10.dp) {
//                Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
//
//                    Text(text = "Movies", color = Color.Green)
//                }
//
//
//            }
//        }) {
//            content()
//        }
        content()


    }

}




@Composable
fun MovieRow(movie: String,onItemClick:(String)->Unit ={ }) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                onItemClick(movie)

            },
        shape = RoundedCornerShape(
            corner = CornerSize(16.dp)
        ), elevation = 8.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

        Surface(
            Modifier
                .padding(12.dp)
                .size(100.dp), shape = RectangleShape, elevation = 8.dp) {
         Icon(imageVector = Icons.Default.AccountBox, contentDescription ="Image" )

        }
            Text(text = movie)

        }



    }

}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieAppTheme {
        MyApp {
           MovieNavigation()
        }
    }
}