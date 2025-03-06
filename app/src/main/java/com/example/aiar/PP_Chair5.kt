package com.example.aiar

import android.Manifest
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Chair5PP(navController: NavHostController, modifier: Modifier = Modifier, name: String) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    // State to track camera permission
    var isCameraPermissionGranted by remember { mutableStateOf(false) }

    // Launcher for requesting camera permission
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        isCameraPermissionGranted = isGranted
        if (isGranted) {
            // Open Camera or Handle Camera Feature
            openCamera(context)
        } else {
            Toast.makeText(context, "Camera permission is required", Toast.LENGTH_SHORT).show()
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()  // To adapt to any screen size
            .background(color = Color.White)
            .verticalScroll(scrollState)  // Added vertical scroll
    ) {
        Column {  // Use Column for vertical scrolling
            Image(
                painter = painterResource(id = R.drawable.pp_chiar5),
                contentDescription = "round chair",
                modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeight(375.dp)
                    .clip(RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
            )

            // Back arrow with click event
            Image(
                painter = painterResource(id = R.drawable.arrow_back),
                contentDescription = "arrow_back",
                colorFilter = ColorFilter.tint(Color(0xff1d1b20)),
                modifier = Modifier
                    .align(Alignment.Start)
                    .offset(x = 8.dp, y = (-363).dp)
                    .requiredSize(30.dp)
                    .clickable {
                        navController.navigate("Chairs") // Navigate to ChairsMain.kt screen
                    }
            )


            Text(
                text = "Comfortable Chair With Cushion",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .padding(start = 13.dp, top = 20.dp)
                    .fillMaxWidth()
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 18.dp, top = 10.dp, end = 18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Rs. 10,000",
                    color = Color(0xff043a52),
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.weight(1f)
                )

                // Camera Icon
                Image(
                    painter = painterResource(id = R.drawable.ar_view),
                    contentDescription = "Open Camera",
                    modifier = Modifier
                        .requiredSize(40.dp) // Increased size for better visibility
                        .background(Color.White) // Add background to verify presence
                        .clickable {
                            if (isCameraPermissionGranted) {
                                openCamera(context) // Call your openCamera function
                            } else {
                                permissionLauncher.launch(Manifest.permission.CAMERA)
                            }
                        }
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(13.dp)
            ) {
                // Free Delivery
                Column(modifier = Modifier.weight(1f)) {
                    Image(
                        painter = painterResource(id = R.drawable.delivery_icon),
                        contentDescription = "Truck",
                        modifier = Modifier
                            .requiredSize(28.dp)
                    )
                    Text(
                        text = "Free Delivery",
                        color = Color.Black,
                        style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold),
                    )
                }

                // Secure Payment
                Column(modifier = Modifier.weight(1f)) {
                    Image(
                        painter = painterResource(id = R.drawable.security_icon),
                        contentDescription = "Security",
                        modifier = Modifier
                            .requiredSize(28.dp)
                    )
                    Text(
                        text = "Secure Payment",
                        color = Color.Black,
                        style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold),
                    )
                }

                // Easy Return
                Column(modifier = Modifier.weight(1f)) {
                    Image(
                        painter = painterResource(id = R.drawable.return_icon),
                        contentDescription = "return",
                        modifier = Modifier
                            .requiredSize(28.dp)
                            .rotate(28.05f)
                    )
                    Text(
                        text = "Easy Return",
                        color = Color.Black,
                        style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold),
                    )
                }

                // Best Brand
                Column(modifier = Modifier.weight(1f)) {
                    Image(
                        painter = painterResource(id = R.drawable.brand_icon),
                        contentDescription = "brand",
                        modifier = Modifier
                            .requiredSize(28.dp)
                    )
                    Text(
                        text = "Best Brand",
                        color = Color.Black,
                        style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Bold),
                    )
                }
            }

            // BUY NOW Button
            Box(
                modifier = Modifier
                    .width(210.dp)  // This makes the Box take the full width of the screen
                    .padding(horizontal = 10.dp)
                    .padding(vertical = 20.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xff3c687f))
                    .padding(vertical = 10.dp)
                    .align(Alignment.CenterHorizontally)  // Centers the Box horizontally
            ) {
                Text(
                    text = "BUY NOW",
                    color = Color.White,
                    style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.align(Alignment.Center)  // Centers the text within the Box
                )
            }


            // ADD TO CART Button
            Box(
                modifier = Modifier
                    .width(290.dp)
                    .padding(vertical = 10.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xff3c687f))
                    .padding(vertical = 10.dp)
                    .align(Alignment.CenterHorizontally)  // Centers the Box horizontally
            ) {
                Text(
                    text = "ADD TO CART",
                    color = Color.White,
                    style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
@Preview(widthDp = 360, heightDp = 800)
fun Chair5PPPreview() {
    val navController = rememberNavController()
    Chair5PP(navController = navController, name = "Android")
}
