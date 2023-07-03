package com.example.android.meditationui.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android.meditationui.R
import com.example.android.meditationui.data.MeditationUiObjects.chips

@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()
        ) {
        Column() {
            GreetingSection()
            ChipSection(chips = chips)
        }
    }

}

@Composable
fun GreetingSection( modifier: Modifier = Modifier, name: String = "Gozie"){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier) {
            Text(
                text = "Good Morning, $name",
                color = TextWhite,
                style = MaterialTheme.typography.headlineMedium
                )
            Text(
                text = "We wish you have a good day!",
                color = TextWhite,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(20.dp)

            )
    }
}

@Composable
fun ChipSection(
    chips: List<String>
){
    var selectedChips by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                    .clickable { selectedChips = it }
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (selectedChips == it) ButtonBlue else DarkerButtonBlue)
                    .padding(16.dp)) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MeditationUiPreview() {
    MeditationUiTheme {
        HomeScreen()
    }
}