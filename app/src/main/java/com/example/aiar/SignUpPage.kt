package com.example.aiar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
import com.example.aiar.ui.theme.AiARTheme

class SignUp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AiARTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignIn(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SignIn(modifier: Modifier = Modifier, name: String) {
    Box(
        modifier = modifier
            .requiredWidth(width = 360.dp)
            .requiredHeight(height = 800.dp)
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.sign_reg),
            contentDescription = "Sign Image",
            modifier = Modifier
                .requiredWidth(width = 550.dp)
                .requiredHeight(height = 800.dp)
        )
        Box(
            modifier = Modifier
                .requiredWidth(width = 360.dp)
                .requiredHeight(height = 800.dp)
        )
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 32.dp, y = 149.dp)
                .requiredWidth(width = 300.dp)
                .requiredHeight(height = 471.dp)
                .clip(shape = RoundedCornerShape(40.dp))
                .background(color = Color(0xffd9d9d9).copy(alpha = 0.5f))
        )
        Text(
            text = "SIGN IN",
            color = Color.Black,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 144.dp, y = 180.dp)
                .requiredWidth(width = 137.dp)
                .requiredHeight(height = 62.dp)
        )
        HorizontalDivider(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 78.dp, y = 319.dp)
                .requiredWidth(width = 209.dp),
            color = Color.Black
        )
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 78.dp, y = 365.dp)
                .requiredWidth(width = 209.dp)
                .requiredHeight(height = 47.dp)
        ) {
            Text(
                text = "Password",
                color = Color(0xff808080),
                style = TextStyle(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .requiredWidth(width = 179.dp)
                    .requiredHeight(height = 25.dp)
            )
            HorizontalDivider(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 0.dp, y = 47.dp)
                    .requiredWidth(width = 209.dp),
                color = Color.Black
            )
        }
        TextButton(
            onClick = { },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 125.dp, y = 494.dp)
                .requiredWidth(width = 173.dp)
                .requiredHeight(height = 40.dp)
        ) {
            Box(
                modifier = Modifier
                    .requiredWidth(width = 173.dp)
                    .requiredHeight(height = 40.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 128.dp)
                        .requiredHeight(height = 40.dp)
                        .clip(shape = RoundedCornerShape(30.dp))
                        .background(color = Color(0xff716464))
                )
                Text(
                    text = "GET IN",
                    color = Color.White,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 40.dp, y = 10.dp)
                        .requiredWidth(width = 143.dp)
                        .requiredHeight(height = 33.dp)
                )
            }
        }
        Text(
            text = "Email",
            color = Color(0xff808080),
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 78.dp, y = 270.dp)
                .requiredWidth(width = 179.dp)
                .requiredHeight(height = 25.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.arrow_back),
            contentDescription = "Arrow Back",
            colorFilter = ColorFilter.tint(Color(0xff1d1b20)),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 25.dp, y = 20.dp)
                .requiredSize(size = 30.dp)
        )
    }
}

@Preview(widthDp = 360, heightDp = 800)
@Composable
private fun SignInPreview() {
    SignIn(Modifier, "Android")
}
