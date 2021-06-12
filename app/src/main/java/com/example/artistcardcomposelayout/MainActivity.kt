package com.example.artistcardcomposelayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artistcardcomposelayout.ui.theme.ArtistCardComposeLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtistCardComposeLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ArtistCard()
                }
            }
        }
    }
}


@Composable
fun ArtistCard(modifier: Modifier = Modifier) {

    AppBar(modifier)

    LazyColumn(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        item {
            ArtistCardTopLayout(modifier)
            ArtistCardBottomCard(modifier)
            ArtistDetails(modifier)
        }

    }

}

@Composable
fun AppBar(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "My Portfolio",
                        color = Color.Blue,
                    )
                },
                backgroundColor = Color.Blue,
                contentColor = Color.White,
                elevation = 12.dp
            )
        },
    ) {
    }
}

@Composable
fun ArtistDetails(modifier: Modifier = Modifier) {
    Text(
        text =
        "Hi I am Natavar Prajapati\n" +
                "I have started my android career on 04 Feb , 2021.\n" +
                "I want to become a best in Android.",
        color = Color.Black,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
fun ArtistCardBottomCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = 10.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.mypic),
            contentDescription = "MyBigImage",
            contentScale = ContentScale.FillBounds,
            modifier = modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ArtistCardTopLayout(modifier: Modifier = Modifier) {
    Row(
        modifier
            .clickable(onClick = {})
            .padding(16.dp)
    ) {
        Surface(
            modifier = modifier.size(50.dp),
            shape = CircleShape,
            color = Color.LightGray
        ) {
            Image(
                painter = painterResource(id = R.drawable.mypic),
                contentDescription = "Mypic",
                modifier = modifier.clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        //column for name and post of user
        Column(
            modifier = modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = "Natavar Prajapati",
                fontWeight = FontWeight.ExtraBold
            )
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(
                    text = "Junior Android Developer",
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtistCardComposeLayoutTheme {
        ArtistCard()
    }
}

@Preview(showBackground = true)
@Composable
fun ArtistCardTopLayoutPreview() {
    ArtistCardComposeLayoutTheme {
        ArtistCardTopLayout()
    }
}

@Preview
@Composable
fun ArtistCardBottomCardPreview() {
    ArtistCardComposeLayoutTheme {
        ArtistCardBottomCard()
    }
}

@Preview
@Composable
fun ArtistDetailsPreview() {
    ArtistCardComposeLayoutTheme {
        ArtistDetails()
    }
}