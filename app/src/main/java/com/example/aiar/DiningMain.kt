package com.example.aiar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
fun Dining(navController: NavHostController, modifier: Modifier = Modifier, name: String) {
    Box(
        modifier = modifier
            .fillMaxSize() // Allow the Box to fill the available screen size
            .background(color = Color.White)
    ) {
        // Search box
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 66.dp, start = 16.dp, end = 16.dp) // Adaptive padding
                .fillMaxWidth() // Fill width for any screen size
                .height(49.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .border(1.dp, Color(0xff747474), RoundedCornerShape(16.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.search_icon),
                contentDescription = "Search",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 12.dp)
                    .size(23.dp)
            )
            Text(
                text = "Let’s find Dining Table you want",
                color = Color(0xff8f8d8d),
                style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 47.dp)
            )
        }

        // Title "Wardrobe"
        Text(
            text = "Dining Tables",
            color = Color(0xff043a52),
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 20.dp)
        )

        // Chair items grid in two columns with vertical scrolling
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 150.dp, start = 16.dp, end = 16.dp) // Adaptive padding
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                DiningItem(
                    imageRes = R.drawable.dining1,
                    name = "Rustic Rectangular Dining Table",
                    navController = navController,    // Pass NavController
                    detailPageRoute = "Dine1PP"  // Pass the route to navigate to the detail page
                )
            }
            item {
                DiningItem(
                    imageRes = R.drawable.dining2,
                    name = "Wood Rosewood Dining Table",
                    navController = navController,    // Pass NavController
                    detailPageRoute = "Dine2PP"  // Pass the route to navigate to the detail page
                )
            }
            item {
                DiningItem(
                    imageRes = R.drawable.dining3,
                    name = "Sheesham Wood Dining Table",
                    navController = navController,    // Pass NavController
                    detailPageRoute = "Dine3PP"  // Pass the route to navigate to the detail page
                )
            }
            item {
                DiningItem(
                    imageRes = R.drawable.dining4,
                    name = "Wooden Dining Table 4 Seater",
                    navController = navController,    // Pass NavController
                    detailPageRoute = "Dine4PP"  // Pass the route to navigate to the detail page
                )
            }
            item {
                DiningItem(
                    imageRes = R.drawable.dining5,
                    name = "Minimal Dining",
                    navController = navController,    // Pass NavController
                    detailPageRoute = "Dine5PP"  // Pass the route to navigate to the detail page
                )
            }
            item {
                DiningItem(
                    imageRes = R.drawable.dining6,
                    name = "Japanese 4 Seater Dining Table",
                    navController = navController,    // Pass NavController
                    detailPageRoute = "Dine6PP"  // Pass the route to navigate to the detail page
                )
            }
        }
        // Back arrow
        Image(
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = "Back Arrow",
            colorFilter = ColorFilter.tint(Color(0xff1d1b20)),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 16.dp)
                .size(30.dp)
                .clickable {
                    navController.navigate("HomeScreen") // Replace "home" with your home screen's route
                }
        )
    }
}

@Composable
fun DiningItem(
    imageRes: Int,
    name: String,
    navController: NavController, // Add NavController parameter
    detailPageRoute: String        // Add route for detail page
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                // Navigate to the respective detail page
                navController.navigate(detailPageRoute)
            }
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            modifier = Modifier
                .size(152.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
        )
        Text(
            text = name,
            color = Color.Black,
            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(top = 8.dp)
        )
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun DiningPreview() {
    val navController = rememberNavController()
    Dining(navController = navController, name = "Android")
}
