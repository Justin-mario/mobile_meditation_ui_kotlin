package com.example.android.meditationui.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.android.meditationui.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    Column(modifier = modifier
        .background(MaterialTheme.colorScheme.primary)
        .padding(horizontal = 8.dp, vertical = 24.dp)) {
        GreetingSection()
    }
}

@Composable
fun GreetingSection( modifier: Modifier = Modifier, name: String = "Gozie"){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        Column(modifier = modifier, ) {
            Text(text = "Good Morning, $name",
                )
            Text(text = "We wish you have a good day!")
        }

        Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Search")
    }
}

