package com.example.aiar

import android.content.Intent
import android.net.Uri
import android.widget.Toast
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost

@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier = Modifier, name: String) {
    // List of categories and product images
    val categories = listOf("Wardrobe", "Lamps", "Sofa", "Dining Table", "Chairs")
    val productImages = listOf(R.drawable.home_chair1, R.drawable.home_dine1, R.drawable.home_ward1, R.drawable.home_sofa1, R.drawable.home_lamp1)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Top Row for Title and Account Icon
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Get Insta-Worthy Finds!!!",
                    color = Color(0xff043a52),
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontSize = 30.sp
                    ),
                    modifier = Modifier
                        .requiredWidth(303.dp)
                        .requiredHeight(70.dp)
                        .padding(start = 18.dp)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.account_icon),
                        contentDescription = "Account Icon",
                        colorFilter = ColorFilter.tint(Color(0xff1d1b20)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(35.dp)
                            .padding(end = 6.dp)
                            .offset(y = (-5).dp)
                            .clickable {
                                navController.navigate("Account")
                            }
                    )
                    val context = LocalContext.current
                    
                    Button(
    onClick = {
        val intent = Intent(context, AiRecommendationActivity::class.java)
        context.startActivity(intent)
    },
    modifier = Modifier.padding(16.dp)
) {
    Text("AI Recommend")
}

                    Button(
                        onClick = {
                            val packageName = "com.example.package" // Replace with the actual package name
                            val launchIntent = context.packageManager.getLaunchIntentForPackage(packageName)
                            if (launchIntent != null) {
                                context.startActivity(launchIntent)
                            } else {
                                //Toast.makeText(context, "App not found!", Toast.LENGTH_SHORT).show()
                                // Optional: Navigate to Play Store
                                val uri = Uri.parse("https://drive.google.com/file/d/1d8jUgSODh2zRIZ-Lc0C6t8oGVlZPw1PK/view?usp=drivesdk?id=$packageName")
                                val playStoreIntent = Intent(Intent.ACTION_VIEW, uri)
                                context.startActivity(playStoreIntent)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .size(35.dp)
                            .offset(y = (-5).dp)
                    ){
                        Icon(
                            painter = painterResource(id = R.drawable.ar_view), // Replace with your new image resource
                            contentDescription = "Additional Icon",
                            tint = Color(0xff1d1b20),
                            modifier = Modifier.size(35.dp)
                        )
                    }

                }
            }


            // Search Box
            Box(
                modifier = Modifier
                    .padding(start = 20.dp, top = 5.dp)
                    .requiredWidth(320.dp)
                    .requiredHeight(49.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .border(1.dp, Color(0xff747474), RoundedCornerShape(16.dp))
            ) {
                Text(
                    text = "Let’s Find Your Stylish Furniture",
                    color = Color(0xff8f8d8d),
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 47.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = "Search",
                    colorFilter = ColorFilter.tint(Color(0xff1d1b20)),
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 12.dp)
                        .requiredSize(23.dp)
                )
            }

            Text(
                text = "Categories",
                color = Color(0xff043a52),
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium, fontSize = 22.sp),
                modifier = Modifier
                    .padding(start = 18.dp, top = 12.dp)
            )

            // Horizontal Scroll for Categories
            LazyRow(
                modifier = Modifier
                    .padding(start = 18.dp, top = 10.dp)
                    .requiredHeight(60.dp)
            ) {
                items(categories) { category ->
                    Box(
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .clip(RoundedCornerShape(25.dp))
                            .background(Color(0xff043a52).copy(alpha = 0.7f))
                            .requiredWidth(162.dp)
                            .requiredHeight(47.dp)
                            .clickable {
                                when (category) {
                                    "Wardrobe" -> navController.navigate("Wardrobe")
                                    "Lamps" -> navController.navigate("Lamp")
                                    "Sofa" -> navController.navigate("Sofa")
                                    "Dining Table" -> navController.navigate("Dining")
                                    "Chairs" -> navController.navigate("Chairs")
                                }
                            }
                    ) {
                        Text(
                            text = category,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium, fontSize = 18.sp),
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    }
                }
            }


            Text(
                text = "Vibe Check Your Must-Haves!",
                color = Color(0xff043a52),
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier
                    .padding(start = 20.dp, top = 16.dp)
            )

            // Vertical Scroll for Product Images
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp)
            ) {
                items(productImages) { image ->
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                            .requiredHeight(245.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .clickable {
                                if (image == R.drawable.home_chair1) {
                                    // Navigate to PP_Chair1.kt page
                                    navController.navigate("Chair1PP")
                                }
                                if (image == R.drawable.home_dine1){
                                    navController.navigate("Dine1PP")
                                }
                                if (image == R.drawable.home_ward1){
                                    navController.navigate("Ward1PP")
                                }
                                if (image == R.drawable.home_sofa1){
                                    navController.navigate("Sofa1PP")
                                }
                                if (image == R.drawable.home_lamp1){
                                    navController.navigate("Lamp1PP")
                                }

                            }
                    )
                }
            }
        }
    }
}

@Composable
fun PP_Chair1Screen() {
    // Content of PP_Chair1 screen
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "PP Chair 1 Screen", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable("HomeScreen") { HomeScreen(navController, name = "Android") }
        composable("PP_Chair1") { PP_Chair1Screen() }
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController, name = "Android")
}