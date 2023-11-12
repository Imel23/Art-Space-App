package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceScreen()
            }
        }
    }
}

@Composable
fun ArtSpaceScreen(){
    val image = painterResource(id = R.drawable.scott)
    val contentDescription= "Scott Owen art"
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
           ArtWorkWall(
            image,
            contentDescription,
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 60.dp)
           )
            ArtWorkDescriptor(
                artWorkTitle= stringResource(id = R.string.art_description),
                artWorkArtist=stringResource(id = R.string.art_author),
                modifier=Modifier,
            )
            DisplayController()

    }
}

@Composable
fun ArtWorkWall(
    image: Painter,
    contentDescription:String,
    modifier:Modifier,
){
    Surface(
        modifier = modifier,
        shadowElevation = 9.dp
    ) {
        Image(
            painter = image,
            contentDescription = contentDescription,
            contentScale = ContentScale.Fit,
            modifier = Modifier.padding(40.dp)
        )
    }
}

@Composable
fun ArtWorkDescriptor(
    artWorkTitle: String,
    artWorkArtist: String,
    modifier: Modifier
){
    Surface(
        modifier= Modifier
            .fillMaxWidth()
            .padding(20.dp),
        color = Color(0xFFecebf4),
    ){
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,

        ) {
            Text(
                text = artWorkTitle,
                fontSize = 25.sp,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp)
            )
            Text(
                text = artWorkArtist,
                fontSize = 15.sp,
                textAlign = TextAlign.Left,
                fontWeight = FontWeight.Black,
                modifier = Modifier.padding(start = 20.dp, top = 10.dp, bottom = 20.dp, end = 20.dp)
            )
        }
    }

}

@Composable
fun DisplayController(){
    Row(
        horizontalArrangement=Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff495c92)
            ),
            modifier = Modifier
                .widthIn(min = 150.dp)
                .heightIn(min = 70.dp)
                .padding(10.dp),
        ) {
            Text(text = "Previous",
                Modifier.padding(start = 20.dp, end = 20.dp)
            )
        }
        Spacer(modifier = Modifier.padding(20.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff495c92)
            ),
            modifier = Modifier
                .widthIn(min = 150.dp)
                .heightIn(min = 70.dp)
                .padding(10.dp)
        ) {
            Text(text = "Next",
                Modifier.padding(start = 20.dp, end = 20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkWallPreview() {
    ArtSpaceTheme {
        DisplayController()
     }
}