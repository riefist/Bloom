package com.aibangdev.bloom

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aibangdev.bloom.ui.theme.BloomTheme

@Composable
fun HomeScreen() {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {

            Spacer(Modifier.height(40.dp))

            SearchInput()

            BrowseThemeSection()

            HomeGardenSection()

        }
    }
}

@Composable
private fun HomeGardenSection() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = "Design your home garden",
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp),
        )

        Icon(
            Icons.Default.FilterList,
            contentDescription = null,
            modifier = Modifier
                .size(24.dp),
        )
    }

    Spacer(Modifier.height(16.dp))

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        homeGardenThemes.forEach { theme ->
            HomeGardenListItem(plantTheme = theme)
        }
    }
}

@Composable
private fun BrowseThemeSection() {
    Text(
        text = "Browse Themes",
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .paddingFromBaseline(top = 32.dp)
            .padding(horizontal = 16.dp)
    )

    Spacer(Modifier.height(16.dp))

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(start = 16.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        defaultPlantThemes.forEach { theme ->
            PlantThemeCard(plantTheme = theme)
        }
    }
}

@Composable
private fun SearchInput() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = {
            Text(text = "Search")
        },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}

@Preview
@Composable
fun PreviewDarkHome() {
    BloomTheme(darkTheme = true) {
        HomeScreen()
    }
}

@Preview
@Composable
fun PreviewLightHome() {
    BloomTheme(darkTheme = false) {
        HomeScreen()
    }
}