package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    var artIndex by remember { mutableStateOf(0) }

    var image = painterResource(id = R.drawable.pexels_steve_johnson_1545506)
    var contentDescription = stringResource(id = R.string.content_description_1)
    var artWorkTitle=stringResource(id = R.string.art_description_1)
    var artWorkArtist=stringResource(id = R.string.art_author_1)

    when(artIndex){
        0 -> {
            image = painterResource(id = R.drawable.pexels_steve_johnson_1545506)
            contentDescription = stringResource(id = R.string.content_description_1)
            artWorkTitle=stringResource(id = R.string.art_description_1)
            artWorkArtist=stringResource(id = R.string.art_author_1)
        }
        1->{
            image = painterResource(id = R.drawable.pexels_steve_johnson_1109354)
            contentDescription = stringResource(id = R.string.content_description_2)
            artWorkTitle=stringResource(id = R.string.art_description_2)
            artWorkArtist=stringResource(id = R.string.art_author_2)
        }
        2->{
            image = painterResource(id = R.drawable.pexels_ann_h_3095769)
            contentDescription = stringResource(id = R.string.content_description_3)
            artWorkTitle=stringResource(id = R.string.art_description_3)
            artWorkArtist=stringResource(id = R.string.art_author_3)
        }
        3->{
            image = painterResource(id = R.drawable.pexels_torsten_dettlaff_971546)
            contentDescription = stringResource(id = R.string.content_description_4)
            artWorkTitle=stringResource(id = R.string.art_description_4)
            artWorkArtist=stringResource(id = R.string.art_author_4)
        }
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ArtWorkWall(
                image,
                contentDescription,
                modifier = Modifier
                    .weight(0.6f) // Allocate 60% of the space to the image
                    .padding(16.dp) // Apply padding around the image

            )

            ArtWorkDescriptor(
                artWorkTitle = artWorkTitle,
                artWorkArtist = artWorkArtist,
                modifier = Modifier
                    .weight(0.05f) // Allocate 20% of the space to the artwork description
            )
            DisplayController(
                onClickNext = { if (artIndex < 3) artIndex++ else artIndex = 3 },
                onClickPrevious = { if (artIndex > 0) artIndex-- else artIndex = 0 },
                Modifier
                    .weight(0.35f) // Allocate 20% of the space to the display controller
                    .fillMaxWidth()
                    .padding(20.dp)
            )
        }
    }
}

@Composable
fun ArtWorkWall(
    image: Painter,
    contentDescription: String,
    modifier: Modifier,
){
    // Ensure the Surface has a size before applying additional modifiers.
    Surface(
        modifier = modifier,
        shadowElevation = 9.dp,
    ) {
        Image(
            painter = image,
            contentDescription = contentDescription,
            contentScale = ContentScale.Fit, // Adjust this based on your needs
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
        modifier= Modifier,
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
fun DisplayController(onClickNext: ()-> Unit, onClickPrevious: ()-> Unit, modifier: Modifier){
    Row(
        horizontalArrangement=Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
        modifier = modifier
    ){
        Button(
            onClick = onClickPrevious,
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
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = onClickNext,
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
     }
}