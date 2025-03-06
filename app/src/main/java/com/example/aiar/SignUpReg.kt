package com.example.aiar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SignUpReg(navController: NavController, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 360.dp)
            .requiredHeight(height = 800.dp)
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.sign_reg),
            contentDescription = "Background Image",
            modifier = Modifier
                .requiredWidth(width = 550.dp)
                .requiredHeight(height = 800.dp)
                .align(Alignment.TopCenter)
        )

        Image(
            painter = painterResource(id = R.drawable.ellipse2),
            contentDescription = "Decorative Ellipse",
            alpha = 0.6f,
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = (-150.dp), y = (100.dp))
                .requiredWidth(width = 500.dp)
                .requiredHeight(height = 1980.dp)
                .rotate(degrees = -360.01f)
        )

        // Sign Up button box
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 43.dp, y = 315.dp)
                .requiredWidth(width = 127.dp)
                .requiredHeight(height = 38.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .background(color = Color(0xffd4d4d2))
                .clickable { navController.navigate("SignUpPage") } // Navigate to SignUp Page
        )

        // Sign Up text
        Text(
            text = "SIGN UP",
            color = Color(0xff351905),
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 80.dp, y = 325.dp)
        )

        // Register button box
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 29.dp, y = 386.dp)
                .requiredWidth(width = 156.dp)
                .requiredHeight(height = 40.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .background(color = Color(0xffd4d4d2))
                .clickable { navController.navigate("Register") } // Navigate to Register Page
        )

        // Register text
        Text(
            text = "REGISTER",
            color = Color(0xff351905),
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 75.dp, y = 400.dp)
        )
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun SignUpRegPreview() {
    val navController = rememberNavController()
    SignUpReg(navController = navController)
}
