package com.example.android.meditationui.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android.meditationui.R
import com.example.android.meditationui.data.BottomMenuContent
import com.example.android.meditationui.data.Feature
import com.example.android.meditationui.data.MeditationUiObjects.bottomMenuItems
import com.example.android.meditationui.data.MeditationUiObjects.chips
import com.example.android.meditationui.data.MeditationUiObjects.features
import com.example.android.meditationui.standardQuadFromTo

@Composable
fun HomeScreen() {
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()
        ) {
        Column {
            GreetingSection()
            ChipSection(chips = chips)
            CurrentMeditation()
            FeatureSection(feature = features)
        }
        BottomMenu(items = bottomMenuItems, modifier = Modifier.align(Alignment.BottomCenter))
    }

}

@Composable
fun GreetingSection( modifier: Modifier = Modifier, name: String = stringResource(id = R.string.user_name)) {
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
                text = stringResource(id = R.string.welcome_message),
                color = TextWhite,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = stringResource(id = R.string.search),
            tint = Color.White,
            modifier = Modifier.size(20.dp)

            )
    }
}

@Composable
fun ChipSection(chips: List<String>) {
    var selectedChips by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
                    .clickable { selectedChips = it }
                    .clip(MaterialTheme.shapes.small)
                    .background(if (selectedChips == it) ButtonBlue else DarkerButtonBlue)
                    .padding(16.dp)) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}

@Composable
fun CurrentMeditation(color: Color = LightRed) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(16.dp)
            .clip(MaterialTheme.shapes.small)
            .background(color)
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .fillMaxWidth()
           ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier) {
            Text(
                text = stringResource(id = R.string.daily_thought),
                color = TextWhite,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = stringResource(id = R.string.meditation_time),
                color = TextWhite,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Box(contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(CircleShape)
                .background(ButtonBlue)
                .size(40.dp)
                .padding(10.dp)
            ){
            Icon(
                painter = painterResource(id = R.drawable.ic_play),
                contentDescription = stringResource(id = R.string.play),
                tint = Color.White,
                modifier = Modifier.size(16.dp)

            )
        }

    }
}

@Composable
fun FeatureSection(feature: List<Feature>) {
    Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = R.string.features),
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(16.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()) {
            items(feature.size) {
                FeatureItem(feature = feature[it])
            }
        }
    }
}

@Composable
fun FeatureItem(feature: Feature) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(MaterialTheme.shapes.small)
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

//        medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(mediumColoredPoint1.x, mediumColoredPoint1.y)
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }


        val lightColoredPoint1 = Offset(0f, height * 0.35f)
        val lightColoredPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightColoredPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightColoredPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightColoredPoint5 = Offset(width * 1.4f, -height.toFloat()/ 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightColoredPoint1.x, lightColoredPoint1.y)
            standardQuadFromTo(lightColoredPoint1, lightColoredPoint2)
            standardQuadFromTo(lightColoredPoint2, lightColoredPoint3)
            standardQuadFromTo(lightColoredPoint3, lightColoredPoint4)
            standardQuadFromTo(lightColoredPoint4, lightColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }



        Canvas(modifier = Modifier.fillMaxSize()) {


            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )

        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.headlineMedium,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart))

            Text(
                text =  "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable { // Handle the click
                    }
                    .align(Alignment.BottomEnd)
                    .clip(MaterialTheme.shapes.small)
                    .background(ButtonBlue)
                    .padding(vertical = 6.dp, horizontal = 16.dp)
                )
        }
    }
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
       var selectedItemIndex by remember {
           mutableStateOf(initialSelectedItemIndex)
       }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(vertical = 16.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
                activeHighlightColor = activeHighlightColor
            ) {
                    selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item:BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable { onItemClick() }) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.small)
                    .background(if (isSelected) activeHighlightColor else Color.Transparent)
                    .padding(10.dp)
                    ) {
                Icon(
                    painter = painterResource(id = item.iconId),
                    contentDescription = item.title,
                    tint = if (isSelected) activeTextColor else inactiveTextColor,
                    modifier = Modifier.size(20.dp))
            }
        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor)

    }
}

@Preview(showBackground = true)
@Composable
fun MeditationUiPreview() {
    MeditationUiTheme {
        HomeScreen()
    }
}