package com.aibangdev.bloom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aibangdev.bloom.ui.theme.BloomTheme

@Composable
fun HomeGardenListItem(plantTheme: PlantTheme) {
    Row(
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
    ) {
        PlantImage(plantTheme)

        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 16.dp)
        ) {
            TitleDescriptionAndCheckBox(plantTheme)

            Divider()
        }
    }

}

@Composable
private fun TitleDescriptionAndCheckBox(plantTheme: PlantTheme) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        TitleAndDescription(plantTheme)

        PlantCheckBox()
    }
}

@Composable
private fun PlantCheckBox() {
    val checkedState = remember {
        mutableStateOf(false)
    }

    Checkbox(
        checked = checkedState.value,
        onCheckedChange = { isChecked ->
            checkedState.value = isChecked
        },
        colors = CheckboxDefaults.colors(
            checkmarkColor = MaterialTheme.colors.background
        ),
        modifier = Modifier
            .size(24.dp)
    )
}

@Composable
private fun RowScope.TitleAndDescription(plantTheme: PlantTheme) {
    Column(
        modifier = Modifier
            .weight(1F)
    ) {
        Text(
            text = plantTheme.title,
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp)
        )

        Text(
            text = "This is description",
            style = MaterialTheme.typography.body2,
            modifier = Modifier
        )
    }
}

@Composable
private fun PlantImage(plantTheme: PlantTheme) {
    Image(
        painter = painterResource(id = plantTheme.imageRes),
        contentDescription = "${plantTheme.title} Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(64.dp)
            .clip(MaterialTheme.shapes.small)
    )
}

@Preview
@Composable
fun PreviewDarkItem() {
    BloomTheme(darkTheme = true) {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            HomeGardenListItem(plantTheme = homeGardenItems.first())
        }
    }


}

@Preview
@Composable
fun PreviewLightItem() {

    BloomTheme(darkTheme = false) {
        Surface(
            color = MaterialTheme.colors.background
        ) {

            HomeGardenListItem(plantTheme = homeGardenItems.first())
        }
    }
}