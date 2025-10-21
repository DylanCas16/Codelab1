package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BirthdayText(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
            BirthdayImage()
        }
    }
}

@Composable
fun BirthdayText(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Happy birthday $name!",
            modifier = modifier.padding(0.dp, 100.dp),
            textAlign = TextAlign.Center,
            fontSize = 70.sp,
            lineHeight = 80.sp

        )
        Text(
            text = "from your best friend",
            modifier = modifier.align(alignment = Alignment.End).padding(20.dp, 60.dp),
            fontSize = 30.sp
            )
    }
}

@Composable
fun BirthdayImage() {
    Image(
        painter = painterResource(R.drawable.fondo_de_pantalla),
        contentDescription = "Wallpaper",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize(),
        alpha = 0.9f
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "BirthdayCard"
)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        Box(modifier = Modifier.fillMaxSize()){
            BirthdayImage()
            Column {
                BirthdayText("James")
            }


        }
    }
}