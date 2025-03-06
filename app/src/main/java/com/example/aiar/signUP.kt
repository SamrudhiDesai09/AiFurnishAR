package com.example.aiar

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SignUpPage(navController: NavHostController, modifier: Modifier = Modifier, name: String) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = modifier
            .requiredWidth(360.dp)
            .requiredHeight(800.dp)
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.sign_reg),
            contentDescription = "Sign Image",
            modifier = Modifier
                .requiredWidth(550.dp)
                .requiredHeight(800.dp)
        )
        Box(
            modifier = Modifier
                .requiredWidth(360.dp)
                .requiredHeight(800.dp)
        )
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(32.dp, 149.dp)
                .requiredWidth(300.dp)
                .requiredHeight(471.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(Color(0xffd9d9d9).copy(alpha = 0.5f))
        )
        Text(
            text = "SIGN IN",
            color = Color.Black,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(144.dp, 180.dp)
                .requiredWidth(137.dp)
                .requiredHeight(62.dp)
        )

        // Email input field with underline
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }, // Label for the field
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(78.dp, 250.dp)
                .requiredWidth(209.dp)
          ,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            ),
            singleLine = true,
            textStyle = TextStyle(color = Color.Black)
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") }, // Label for the field
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(78.dp, 320.dp)
                .requiredWidth(209.dp)
                , // Optional background for better appearance
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            ),
            textStyle = TextStyle(color = Color.Black),
            visualTransformation = PasswordVisualTransformation() // To hide password characters
        )


        // Error message
        errorMessage?.let {
            Text(
                text = it,
                color = Color.Red,
                style = TextStyle(fontSize = 12.sp),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(78.dp, 420.dp)
            )
        }

        // GET IN Button
        TextButton(
            onClick = {
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    val auth = FirebaseAuth.getInstance()

                    // Sign in with Firebase
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                // Navigate to HomeScreen if authentication is successful
                                try {
                                    navController.navigate("HomeScreen")
                                } catch (e: Exception) {
                                    Log.e("NavigationError", "Navigation to HomeScreen failed", e)
                                    errorMessage = "Login Failed. Please try again."
                                }
                            } else {
                                // Authentication failed, show error message
                                Log.e("AuthError", "Authentication failed", task.exception)
                                errorMessage = "Authentication failed. Please check your email and password."
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.e("AuthFailure", "Sign in failure", exception)
                            errorMessage = "Authentication failed. Please check your email and password."
                        }
                } else {
                    errorMessage = "Please enter both email and password."
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(125.dp, 494.dp)
                .requiredWidth(173.dp)
                .requiredHeight(40.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredWidth(173.dp)
                    .requiredHeight(40.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(128.dp)
                        .requiredHeight(40.dp)
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color(0xff716464))
                )
                Text(
                    text = "GET IN",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(40.dp, 10.dp)
                        .requiredWidth(143.dp)
                        .requiredHeight(33.dp)
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = "Arrow Back",
            colorFilter = ColorFilter.tint(Color(0xff1d1b20)),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(25.dp, 20.dp)
                .requiredSize(30.dp)
                .clickable { navController.navigate("SignUpReg") } // Navigate back to SignUpReg
        )
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun SignInPreview() {
    val navController = rememberNavController()
    SignUpPage(navController = navController, name = "Android")
}
