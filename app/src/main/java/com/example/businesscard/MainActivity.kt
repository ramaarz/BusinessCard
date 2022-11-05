package com.example.businesscard

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}



@Composable
fun BusinessCardApp() {
    BusinessCardTitle(
        name = "Teuku Rama",
        title = "Student",
        imageLogo = painterResource(id = R.drawable.android_logo),
        modifier = Modifier
            .wrapContentSize(Alignment.Center)
    )
    BusinessCardContact(
        contact = "rama.teuku@outlook.co.id",
        phone = "082120105798",
        socialMedia = "instagram.com/raamstronaut",
        imageEmail = painterResource(id = R.drawable.ic_baseline_email_24),
        imagePhone = painterResource(id = R.drawable.ic_baseline_phone_24),
        imageSocial = painterResource(id = R.drawable.ic_baseline_person_pin_24),
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.BottomEnd)
            .padding(8.dp)
            )


}

@Composable
private fun BusinessCardTitle(
    imageLogo: Painter,
    name: String,
    title: String,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = imageLogo, contentDescription = null, Modifier.size(90.dp))
        Text(
            text = name,
        fontSize = 42.sp,
        modifier = Modifier.padding(4.dp),
            color = Color.White

        )
        Text(
            text = title,
        fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(2.dp),
        color = Color.White
        )

    } 

}

@Composable
private fun BusinessCardContact(
    contact: String,
    phone: String,
    socialMedia: String,
    imageEmail: Painter,
    imagePhone: Painter,
    imageSocial: Painter,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .padding(8.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Top
    ){
        Row() {
           Text(
               text = contact,
           fontSize = 18.sp,
           modifier = Modifier.padding(4.dp),
           color = Color.White)
            Image(painter = imageEmail, contentDescription = "Email",
                modifier = Modifier.padding(4.dp))
        }
        Row() {
            Text(
                text = phone,
                fontSize = 18.sp,
                modifier = Modifier.padding(4.dp),
                color = Color.White
        )
            Image(painter = imagePhone, contentDescription = "Phone",
            modifier = Modifier.padding(4.dp))
        }
        Row() {
            Text(
                text = socialMedia,
                fontSize = 18.sp,
                modifier = Modifier.padding(4.dp),
                color = Color.White
        )
            Image(painter = imageSocial, contentDescription = null,
                modifier = Modifier.padding(4.dp))
        }

    }
}


@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}