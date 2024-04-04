package com.example.kartunama

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kartunama.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeKartuApp()
                }
            }
        }
    }
}

@Composable
fun ComposeKartuApp() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFd2e8d4))
    ) {
        LogoCard(Modifier.weight(3f))
        CardInfo(Modifier.weight(1f))
    }

}

@Composable
fun LogoCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxWidth()
    ) {
        val image = painterResource(id = R.drawable.android_logo)
        Image(
            painter = image, contentDescription = null, modifier = Modifier.size(150.dp)
        )
        Text(text = stringResource(R.string.logo_text_1), fontSize = 38.sp)
        Text(
            text = stringResource(R.string.logo_text_2), color = Color(0xFF258051), fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun CardInfo(modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally ,modifier = modifier.fillMaxSize()
    ) {
        ContactInfo(
            icon = Icons.Rounded.Call, text = stringResource(R.string.info_text_1)
        )
        Spacer(modifier = Modifier.height(15.dp))
        ContactInfo(
            icon = Icons.Rounded.Share, text = stringResource(R.string.info_text_2)
        )
        Spacer(modifier = Modifier.height(15.dp))
        ContactInfo(
            icon = Icons.Rounded.Email, text = stringResource(R.string.info_text_3)
        )
    }
}

@Composable
fun ContactInfo(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            icon, tint = Color(0xFF258051) , contentDescription = null, modifier = Modifier.padding(start = 90.dp)
        )
        Text(text = text, modifier = Modifier.padding(start = 20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        ComposeKartuApp()
    }
}