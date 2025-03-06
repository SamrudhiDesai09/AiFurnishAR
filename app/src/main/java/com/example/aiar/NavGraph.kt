package com.example.aiar

import androidx.navigation.NavHostController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.SetupNavGraph(navController: NavHostController) {
    composable(route = "SplashScreen") {
        SplashScreen(name = "Android", navController = navController)
    }
    composable(route = "SignUpReg") {
        SignUpReg(navController = navController)
    }
    composable(route = "signUpPage") {
        SignUpPage(name = "Android", navController = navController)
    }
    composable(route = "Register") {
        Register(name = "Android", navController = navController)
    }
    // Add HomeScreen destination
    composable(route = "HomeScreen") {
        HomeScreen(name = "Android",navController = navController)
    }

    composable(route = "Chair1PP"){
        Chair1PP(navController = navController, name = "Android")
    }

    composable(route = "Chairs"){
        Chairs(navController = navController, name = "Android")
    }
    composable(route = "Wardrobe") {
        Wardrobe(navController = navController, name = "Android")
    }
    composable(route = "Sofa") {
        Sofa(navController = navController, name = "Android")
    }
    composable(route = "Chairs") {
        Chairs(navController = navController, name = "Android")
    }
    composable(route = "Dining") {
        Dining(navController = navController, name = "Android")
    }
    composable(route = "Lamp") {
        Lamp(navController = navController, name = "Android")
    }

}


