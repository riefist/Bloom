package com.aibangdev.bloom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aibangdev.bloom.ui.theme.BloomTheme

@Composable
fun PlantThemeCard(plantTheme: PlantTheme) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .size(136.dp),
    ) {
        Column{
            Image(
                painter = painterResource(id = plantTheme.imageRes),
                contentDescription = "${plantTheme.title} Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(136.dp)
                    .height(96.dp)
            )

            Text(
                text = plantTheme.title,
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp)
                    .padding(horizontal = 16.dp),
            )

        }
    }
}

@Preview
@Composable
fun PreviewDarkPlantThemeCard() {
    BloomTheme(darkTheme = true) {
        PlantThemeCard(
            plantTheme = defaultPlantThemes.first()
        )
    }
}

@Preview
@Composable
fun PreviewLightPlantThemeCard() {
    BloomTheme(darkTheme = false) {
        PlantThemeCard(
            plantTheme = defaultPlantThemes.first()
        )
    }
}