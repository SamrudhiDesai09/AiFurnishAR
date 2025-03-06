package com.example.aiar

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Account(navController: NavHostController, modifier: Modifier = Modifier, name: String) {
    Box(
        modifier = modifier
            .fillMaxSize()  // Adapts to the screen size of any Android phone
            .background(color = Color.White)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 33.dp, y = 52.dp)
                .fillMaxWidth(0.85f)  // Slightly reduce width
        ) {
            Image(
                painter = painterResource(id = R.drawable.account_icon),
                contentDescription = "account_circle",
                colorFilter = ColorFilter.tint(Color(0xff1d1b20)),
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = "My Profile",
                color = Color(0xff043a52),
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(start = 53.dp)
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 145.dp, start = 33.dp)
                .fillMaxWidth(0.85f)  // Slightly reduce width
        ) {
            // Cart
            AccountOptionItem(navController, "Cart", R.drawable.cart_icon, "Cart")
            Spacer(modifier = Modifier.height(30.dp))  // Increased spacing for a nicer look

            // Orders
            AccountOptionItem(navController, "Orders", R.drawable.orders_icon, "Orders")
            Spacer(modifier = Modifier.height(30.dp))  // Increased spacing for a nicer look

            // Address
            AccountOptionItem(navController, "Address", R.drawable.address_icon, "Address")
            Spacer(modifier = Modifier.height(30.dp))  // Increased spacing for a nicer look

            // Feedback
            AccountOptionItem(navController, "Feedback", R.drawable.feedback_icon, "Feedback")
            Spacer(modifier = Modifier.height(30.dp))  // Increased spacing for a nicer look

            // Log Out
            AccountOptionItem(navController, "Log Out", R.drawable.logout_icon, "SignUpReg")
        }

        Image(
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = "Back Arrow",
            colorFilter = ColorFilter.tint(Color(0xff1d1b20)),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 16.dp, top = 16.dp)
                .size(30.dp)
                .clickable { navController.navigate("HomeScreen") }  // Navigation to home screen
        )
    }
}

@Composable
fun AccountOptionItem(navController: NavHostController, text: String, iconResId: Int, route: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(shape = RoundedCornerShape(15.dp))
            .background(color = Color.White)
            .border(BorderStroke(1.dp, Color(0xffd9d9d9)), shape = RoundedCornerShape(15.dp))
            .clickable { navController.navigate(route) }  // Navigation on click
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = text,
                color = Color(0xff043a52),
                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun AccountPreview() {
    val navController = rememberNavController()
    Account(navController = navController, name = "Android")
}
