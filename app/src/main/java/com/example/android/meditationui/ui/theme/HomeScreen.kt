package com.example.android.meditationui.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(modifier: Modifier = Modifier){
    Column(modifier = modifier.background(MaterialTheme.colorScheme.primary)) {
    }
}

@Composable
fun GreetingSection( modifier: Modifier = Modifier, name: String = "Gozie"){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        Column {
            Text(text = "Good Morning, $name",
                )
            Text(text = "We wish you have a good day!")
        }
    }
}

