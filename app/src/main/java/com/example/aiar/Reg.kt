package com.example.aiar

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

@Composable
fun Register(navController: NavHostController, modifier: Modifier = Modifier, name: String) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
            text = "Registration",
            color = Color.Black,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(120.dp, 180.dp)
                .requiredWidth(137.dp)
                .requiredHeight(62.dp)
        )

        // username input field with underline
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            ),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(78.dp, 250.dp)
                .requiredWidth(209.dp)
        )


        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            ),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(78.dp, 320.dp)
                .requiredWidth(209.dp)
        )


// Password input field with underline
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            ),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(78.dp, 395.dp)
                .requiredWidth(209.dp)
        )



        // GET IN Button
        TextButton(
            onClick = {
                val auth = FirebaseAuth.getInstance()

                if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                    // Create a user with email and password
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val user = auth.currentUser

                                // Send email verification
                                user?.sendEmailVerification()
                                    ?.addOnSuccessListener {
                                        Log.d("Register", "Verification email sent.")
                                    }
                                    ?.addOnFailureListener {
                                        Log.e("Register", "Failed to send email verification: ${it.message}")
                                    }

                                // Save user details into Firebase Realtime Database
                                val userId = user?.uid
                                userId?.let {
                                    val database = FirebaseDatabase.getInstance()
                                    val userRef = database.getReference("users").child(it)
                                    val userData = mapOf(
                                        "username" to username,
                                        "email" to email
                                    )
                                    userRef.setValue(userData)
                                        .addOnSuccessListener {
                                            Log.d("Register", "User data saved successfully.")
                                            navController.navigate("SignUpPage") // Navigate on success
                                        }
                                        .addOnFailureListener { e ->
                                            Log.e("Register", "Failed to save user data: ${e.message}")
                                        }
                                }
                            } else {
                                Log.e("Register", "Registration failed: ${task.exception?.message}")
                            }
                        }
                } else {
                    Log.e("Register", "All fields must be filled")
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
                    text = "REGISTER",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .offset(30.dp, 10.dp)
                        .requiredWidth(148.dp)
                        .requiredHeight(40.dp)
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
private fun RegisterPreview() {
    val navController = rememberNavController()
    Register(navController = navController, name = "Android")
}
