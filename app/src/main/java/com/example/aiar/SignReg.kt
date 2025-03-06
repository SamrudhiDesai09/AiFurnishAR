package com.example.aiar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun SignReg(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize().clickable {
        navController.navigate("SignUpReg") // Navigate to SignUpReg
    }) {
        Text("Sign Up Page") // Placeholder for your Sign Up Page content
    }
}
