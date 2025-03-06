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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Address(navController: NavHostController, modifier: Modifier = Modifier, name: String) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 30.dp,
                    y = 41.dp)
                .requiredWidth(width = 307.dp)
                .requiredHeight(height = 55.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.address_icon),
                contentDescription = "image 21",
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 20.dp,
                        y = 10.dp)
                    .requiredSize(size = 40.dp))
            Text(
                text = "Address Details",
                color = Color(0xff043a52),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 90.dp,
                        y = 20.dp)
                    .requiredWidth(width = 242.dp)
                    .requiredHeight(height = 55.dp))
        }
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 30.dp,
                    y = 128.dp)
                .requiredWidth(width = 300.dp)
                .requiredHeight(height = 592.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredWidth(width = 300.dp)
                    .requiredHeight(height = 50.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 300.dp)
                        .requiredHeight(height = 50.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(color = Color.White)
                        .border(border = BorderStroke(1.dp, Color(0xffd9d9d9)),
                            shape = RoundedCornerShape(15.dp)))
                Text(
                    text = "Name\n",
                    color = Color(0xff808080),
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 27.dp,
                            y = 10.dp)
                        .requiredWidth(width = 136.dp)
                        .requiredHeight(height = 28.dp))
            }
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 0.dp,
                        y = 80.dp)
                    .requiredWidth(width = 300.dp)
                    .requiredHeight(height = 50.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 300.dp)
                        .requiredHeight(height = 50.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(color = Color.White)
                        .border(border = BorderStroke(1.dp, Color(0xffd9d9d9)),
                            shape = RoundedCornerShape(15.dp)))
                Text(
                    text = "Phone number\n",
                    color = Color(0xff808080),
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 27.dp,
                            y = 10.dp)
                        .requiredWidth(width = 136.dp)
                        .requiredHeight(height = 28.dp))
            }
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 0.dp,
                        y = 388.dp)
                    .requiredWidth(width = 300.dp)
                    .requiredHeight(height = 50.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 300.dp)
                        .requiredHeight(height = 50.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(color = Color.White)
                        .border(border = BorderStroke(1.dp, Color(0xffd9d9d9)),
                            shape = RoundedCornerShape(15.dp)))
                Text(
                    text = "Pincode",
                    color = Color(0xff808080),
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 27.dp,
                            y = 8.dp)
                        .requiredWidth(width = 177.dp)
                        .requiredHeight(height = 28.dp))
            }
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 0.dp,
                        y = 464.dp)
                    .requiredWidth(width = 300.dp)
                    .requiredHeight(height = 51.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 300.dp)
                        .requiredHeight(height = 50.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(color = Color.White)
                        .border(border = BorderStroke(1.dp, Color(0xffd9d9d9)),
                            shape = RoundedCornerShape(15.dp)))
                Text(
                    text = "Address",
                    color = Color(0xff808080),
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 27.dp,
                            y = 9.dp)
                        .requiredWidth(width = 209.dp)
                        .requiredHeight(height = 42.dp))
            }
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 0.dp,
                        y = 542.dp)
                    .requiredWidth(width = 300.dp)
                    .requiredHeight(height = 50.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 300.dp)
                        .requiredHeight(height = 50.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(color = Color.White)
                        .border(border = BorderStroke(1.dp, Color(0xffd9d9d9)),
                            shape = RoundedCornerShape(15.dp)))
                Text(
                    text = "Landmark\n",
                    color = Color(0xff808080),
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 27.dp,
                            y = 10.dp)
                        .requiredWidth(width = 136.dp)
                        .requiredHeight(height = 28.dp))
            }
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 0.dp,
                        y = 159.dp)
                    .requiredWidth(width = 300.dp)
                    .requiredHeight(height = 50.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 300.dp)
                        .requiredHeight(height = 50.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(color = Color.White)
                        .border(border = BorderStroke(1.dp, Color(0xffd9d9d9)),
                            shape = RoundedCornerShape(15.dp)))
                Text(
                    text = "Email\n",
                    color = Color(0xff808080),
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 27.dp,
                            y = 10.dp)
                        .requiredWidth(width = 136.dp)
                        .requiredHeight(height = 28.dp))
            }
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 0.dp,
                        y = 236.dp)
                    .requiredWidth(width = 300.dp)
                    .requiredHeight(height = 50.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 300.dp)
                        .requiredHeight(height = 50.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(color = Color.White)
                        .border(border = BorderStroke(1.dp, Color(0xffd9d9d9)),
                            shape = RoundedCornerShape(15.dp)))
                Text(
                    text = "City",
                    color = Color(0xff808080),
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 27.dp,
                            y = 8.dp)
                        .requiredWidth(width = 186.dp)
                        .requiredHeight(height = 34.dp))
            }
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 0.dp,
                        y = 312.dp)
                    .requiredWidth(width = 300.dp)
                    .requiredHeight(height = 50.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 300.dp)
                        .requiredHeight(height = 50.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
                        .background(color = Color.White)
                        .border(border = BorderStroke(1.dp, Color(0xffd9d9d9)),
                            shape = RoundedCornerShape(15.dp)))
                Text(
                    text = "State",
                    color = Color(0xff808080),
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 27.dp,
                            y = 7.dp)
                        .requiredWidth(width = 177.dp)
                        .requiredHeight(height = 29.dp))
            }
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
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun AddressPreview() {
    val navController = rememberNavController()
    Address(navController = navController, name = "Android")
}