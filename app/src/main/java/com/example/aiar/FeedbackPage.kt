package com.example.aiar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost

@Composable
fun Feedback(navController: NavHostController, modifier: Modifier = Modifier, name: String) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 67.dp,
                    y = 34.dp)
                .requiredWidth(width = 293.dp)
                .requiredHeight(height = 55.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.feedback_icon),
                contentDescription = "image 22",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 20.dp,
                        y = 15.dp)
                    .requiredWidth(width = 39.dp)
                    .requiredHeight(height = 40.dp))
            Text(
                text = "Feedback",
                color = Color(0xff043a52),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 75.2119140625.dp,
                        y = 20.dp)
                    .requiredWidth(width = 235.dp)
                    .requiredHeight(height = 55.dp))
        }
        Image(
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = "Back Arrow",
            colorFilter = ColorFilter.tint(Color(0xff1d1b20)),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 16.dp)
                .size(30.dp)
                .clickable {
                    navController.navigate("Account") // Replace "home" with your home screen's route
                }
        )
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 37.dp,
                    y = 132.dp)
                .requiredWidth(width = 291.dp)
                .requiredHeight(height = 303.dp)
                .background(color = Color.White)
                .border(border = BorderStroke(1.dp, Color(0xffd9d9d9))))
        Text(
            text = "Add your feedback here...",
            color = Color(0xffc5c2c2),
            style = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 55.dp,
                    y = 151.dp)
                .requiredWidth(width = 253.dp)
                .requiredHeight(height = 54.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 88.dp,
                    y = 509.dp)
                .requiredWidth(width = 193.dp)
                .requiredHeight(height = 56.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredWidth(width = 184.dp)
                    .requiredHeight(height = 56.dp)
                    .clip(shape = RoundedCornerShape(40.dp))
                    .background(color = Color(0xff043a52)))
            Text(
                text = "Send",
                color = Color.White,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 66.dp,
                        y = 18.dp)
                    .requiredWidth(width = 127.dp)
                    .requiredHeight(height = 40.dp))
        }
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun FeedbackPreview() {
    val navController = rememberNavController()
    Feedback(navController = navController, name = "Android")
}