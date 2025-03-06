@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package com.example.aiar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aiar.ui.theme.AiARTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AiARTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "SplashScreen",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("SplashScreen") {
                            SplashScreen(name = "Android", navController = navController) // Pass navController correctly
                        }
                        composable("SignUpReg") {
                            SignUpReg(navController = navController)
                        }
                        composable("signUpPage") {
                            SignUpPage(name = "Android" ,navController = navController)
                        }
                        composable("Register") {
                            Register(navController = navController, name = "Android")
                        }
                        composable("HomeScreen") {
                            HomeScreen(navController = navController, name = "Android")
                        }
                        //home screen product image navigation
                        composable("Chair1PP") {
                            Chair1PP(navController = navController, name = "Android")
                        }
                        composable("Dine1PP") {
                            Dine1PP(navController = navController, name = "Android")
                        }
                        composable("Ward1PP") {
                            Ward1PP(navController = navController, name = "Android")
                        }
                        composable("Sofa1PP") {
                            Sofa1PP(navController = navController, name = "Android")
                        }
                        composable("Lamp1PP") {
                            Lamp1PP(navController = navController, name = "Android")
                        }

                        composable("Chairs") {
                            Chairs(navController = navController, name = "Android")
                        }

                        //Chair Detail Pages
                        composable("Chair1PP") {
                            Chair1PP(navController = navController, name = "Android")
                        }
                        composable("Chair2PP") {
                            Chair2PP(navController = navController, name = "Android")
                        }
                        composable("Chair3PP") {
                            Chair3PP(navController = navController, name = "Android")
                        }
                        composable("Chair4PP") {
                            Chair4PP(navController = navController, name = "Android")
                        }
                        composable("Chair5PP") {
                            Chair5PP(navController = navController, name = "Android")
                        }
                        composable("Chair6PP") {
                            Chair6PP(navController = navController, name = "Android")
                        }

                        //Dining Detail Pages
                        composable("Dine1PP") {
                            Dine1PP(navController = navController, name = "Android")
                        }
                        composable("Dine2PP") {
                            Dine2PP(navController = navController, name = "Android")
                        }
                        composable("Dine3PP") {
                            Dine3PP(navController = navController, name = "Android")
                        }
                        composable("Dine4PP") {
                            Dine4PP(navController = navController, name = "Android")
                        }
                        composable("Dine5PP") {
                            Dine5PP(navController = navController, name = "Android")
                        }
                        composable("Dine6PP") {
                            Dine6PP(navController = navController, name = "Android")
                        }

                        //Sofa Detail Pages
                        composable("Sofa1PP") {
                            Sofa1PP(navController = navController, name = "Android")
                        }
                        composable("Sofa2PP") {
                            Sofa2PP(navController = navController, name = "Android")
                        }
                        composable("Sofa3PP") {
                            Sofa3PP(navController = navController, name = "Android")
                        }
                        composable("Sofa4PP") {
                            Sofa4PP(navController = navController, name = "Android")
                        }
                        composable("Sofa5PP") {
                            Sofa5PP(navController = navController, name = "Android")
                        }
                        composable("Sofa6PP") {
                            Sofa6PP(navController = navController, name = "Android")
                        }

                        //Wardrobe Detail Pages
                        composable("Ward1PP") {
                            Ward1PP(navController = navController, name = "Android")
                        }
                        composable("Ward2PP") {
                            Ward2PP(navController = navController, name = "Android")
                        }
                        composable("Ward3PP") {
                            Ward3PP(navController = navController, name = "Android")
                        }
                        composable("Ward4PP") {
                            Ward4PP(navController = navController, name = "Android")
                        }
                        composable("Ward5PP") {
                            Ward5PP(navController = navController, name = "Android")
                        }
                        composable("Ward6PP") {
                            Ward6PP(navController = navController, name = "Android")
                        }

                        //Lamp Detail Pages
                        composable("Lamp1PP") {
                            Lamp1PP(navController = navController, name = "Android")
                        }
                        composable("Lamp2PP") {
                            Lamp2PP(navController = navController, name = "Android")
                        }
                        composable("Lamp3PP") {
                            Lamp3PP(navController = navController, name = "Android")
                        }
                        composable("Lamp4PP") {
                            Lamp4PP(navController = navController, name = "Android")
                        }
                        composable("Lamp5PP") {
                            Lamp5PP(navController = navController, name = "Android")
                        }
                        composable("Lamp6PP") {
                            Lamp6PP(navController = navController, name = "Android")
                        }

                        //rectangle navigation pages
                        composable("Wardrobe") {
                            Wardrobe(navController = navController, name = "Android")
                        }
                        composable("Sofa") {
                            Sofa(navController = navController, name = "Android")
                        }
                        composable("Chairs") {
                            Chairs(navController = navController, name = "Android")
                        }
                        composable("Dining") {
                            Dining(navController = navController, name = "Android")
                        }
                        composable("Lamp") {
                            Lamp(navController = navController, name = "Android")
                        }

                        //Account Page
                        composable("Account") {
                            Account(navController = navController, name = "Android")
                        }
                        composable("Cart") {
                            Cart(navController = navController, name = "Android")
                        }
                        composable("Address") {
                            Address(navController = navController, name = "Android")
                        }
                        composable("Feedback") {
                            Feedback(navController = navController, name = "Android")
                        }
                        composable("Orders") {
                            Orders(navController = navController, name = "Android")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SplashScreen(name: String, navController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_chair2),
            contentDescription = "image 1",
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(20.dp, 350.dp)
                .requiredWidth(126.dp)
                .requiredHeight(140.dp)
                .rotate(-15f)
        )

        Image(
            painter = painterResource(id = R.drawable.splash_chair2),
            contentDescription = "image 1",
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(20.dp, 350.dp)
                .requiredWidth(126.dp)
                .requiredHeight(140.dp)
                .rotate(-15f)
        )

        Image(
            painter = painterResource(id = R.drawable.splash_chair2),
            contentDescription = "image 1",
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(20.dp, 350.dp)
                .requiredWidth(126.dp)
                .requiredHeight(140.dp)
                .rotate(-15f)
        )

        Image(
            painter = painterResource(id = R.drawable.splash_chair2),
            contentDescription = "image 1",
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(20.dp, 350.dp)
                .requiredWidth(126.dp)
                .requiredHeight(140.dp)
                .rotate(-15f)
        )

        Image(
            painter = painterResource(id = R.drawable.splash_lamp),
            contentDescription = "image 2",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 257.00000705920615.dp,
                    y = 180.dp)
                .requiredWidth(width = 124.dp)
                .requiredHeight(height = 145.dp)
                .rotate(degrees = 12.9f))
        Image(
            painter = painterResource(id = R.drawable.splash_chair1),
            contentDescription = "image 4",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = (6).dp,
                    y = 188.99999296665192.dp)
                .requiredWidth(width = 116.dp)
                .requiredHeight(height = 156.dp)
                .rotate(degrees = -8.62f))
        Image(
            painter = painterResource(id = R.drawable.splash_sofa),
            contentDescription = "image 5",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = (3).dp,
                    y = 23.000011093915873.dp)
                .requiredWidth(width = 138.dp)
                .requiredHeight(height = 125.dp)
                .rotate(degrees = -29.02f))
        Image(
            painter = painterResource(id = R.drawable.splash_bed),
            contentDescription = "image 6",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 107.969970703125.dp,
                    y = 230.90181612968445.dp)
                .requiredWidth(width = 168.dp)
                .requiredHeight(height = 125.dp)
                .rotate(degrees = -15.37f))
        Image(
            painter = painterResource(id = R.drawable.splash_dine),
            contentDescription = "image 7",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 210.00003757323884.dp,
                    y = 335.dp)
                .requiredWidth(width = 154.dp)
                .requiredHeight(height = 110.dp)
                .rotate(degrees = 8.48f))
        Image(
            painter = painterResource(id = R.drawable.splash_chair3),
            contentDescription = "image 8",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 259.93511962890625.dp,
                    y = 18.524835258722305.dp)
                .requiredWidth(width = 101.dp)
                .requiredHeight(height = 110.dp)
                .rotate(degrees = -15.36f))
        Image(
            painter = painterResource(id = R.drawable.spalsh_wardrobe),
            contentDescription = "image 3",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 138.9999856352806.dp,
                    y = 2.dp)
                .requiredWidth(width = 111.dp)
                .requiredHeight(height = 116.dp)
                .rotate(degrees = 11.69f))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 54.dp,
                    y = 154.dp)
                .requiredWidth(width = 268.dp)
                .requiredHeight(height = 90.dp)
        ) {
            Text(
                text = "AiFurnish AR",
                color = Color(0xff1d1b20),
                style = TextStyle(
                    fontSize = 43.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopCenter)
                    .offset(x = 0.dp,
                        y = 0.dp)
                    .requiredWidth(width = 268.dp)
                    .requiredHeight(height = 52.dp))
            Text(
                text = "Augment Your Home",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 44.dp,
                        y = 63.dp)
                    .requiredWidth(width = 215.dp)
                    .requiredHeight(height = 27.dp))
        }
        Image(
            painter = painterResource(id = R.drawable.spalsh_ellipse),
            contentDescription = "Ellipse Side Curve",
            alpha = 0.6f,
            modifier = Modifier
                .align(alignment = Alignment.CenterEnd) // Align to the right side of the screen
                .offset(x = (50).dp, y = (280).dp) // Adjust the offset for proper curve placement
                .requiredWidth(500.dp) // Adjust the width to fit the curve on the side
                .requiredHeight(600.dp) // Adjust the height to fill more of the screen height
                .rotate(degrees = 360f) // Rotate the image to curve along the side
        )

        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 69.dp,
                    y = 580.dp)
                .requiredWidth(width = 244.dp)
                .requiredHeight(height = 59.dp)
        )



        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(85.dp, 600.dp)
                .requiredWidth(244.dp)
                .requiredHeight(59.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xff81c4c5))
                .clickable {
                    navController.navigate("SignUpReg")  // Navigate to SignUpReg when clicked
                }
        ) {
            Text(
                text = "Style Your Heaven",
                color = Color(0xfffcf1fd),
                style = TextStyle(fontSize = 21.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        // Use the 'name' parameter to avoid the unused parameter warning
        Text(
            text = name,
            color = Color.Gray,
            style = TextStyle(fontSize = 12.sp),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        )
    }

//    // Navigate to the SignUpReg screen after a delay
//    LaunchedEffect(Unit) {
//        Handler(Looper.getMainLooper()).postDelayed({
//            navController.navigate("SignUpReg")
//        }, 2000) // 2 seconds delay
    }


@Preview(widthDp = 400, heightDp = 800)
@Composable
private fun SplashScreenPreview() {
    val navController = rememberNavController() // Mock NavController for preview
    SplashScreen("Android", navController)
}
