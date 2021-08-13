package com.aibangdev.bloom

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aibangdev.bloom.ui.theme.BloomTheme
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = viewModel(
        key = null,
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val repository = InMemoryPlantService()
                return HomeViewModel(
                    repository = repository
                ) as T
            }
        }
    )
) {

    val currentState: State<HomeViewState> = homeViewModel.viewState.collectAsState()

    HomeScreenScaffold(state = currentState.value)
}

@Composable
private fun HomeScreenLoader(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
        )
    }
}

@Composable
private fun HomeScreenScaffold(state: HomeViewState) {
    Scaffold(
        bottomBar = {
            BloomBottomBar()
        }
    ) {
        if (state.showLoading) {
            HomeScreenLoader(paddingValues = it)
        } else {
            HomeScreenContent(it, state)
        }
    }

}

@Composable
private fun BloomBottomBar() {
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.primary
    ) {
        BloomBottomButton(
            selected = true,
            icon = Icons.Default.Home,
            labelText = "Home"
        )
        BloomBottomButton(
            selected = false,
            icon = Icons.Default.FavoriteBorder,
            labelText = "Favorites"
        )
        BloomBottomButton(
            selected = false,
            icon = Icons.Default.AccountCircle,
            labelText = "Profile"
        )
        BloomBottomButton(
            selected = false,
            icon = Icons.Default.ShoppingCart,
            labelText = "Cart"
        )
    }
}

@Composable
private fun RowScope.BloomBottomButton(
    selected: Boolean,
    icon: ImageVector,
    labelText: String
) {
    BottomNavigationItem(
        selected = selected,
        onClick = { /*TODO*/ },
        icon = {
            Icon(
                icon,
                contentDescription = null
            )
        },
        label = {
            Text(labelText)
        }
    )
}

@Composable
private fun HomeScreenContent(
    paddingValues: PaddingValues,
    state: HomeViewState
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {

            Spacer(Modifier.height(40.dp))

            SearchInput()

            BrowseThemeSection(state.plantThemes)

            HomeGardenSection(state.homeGardenItems)

        }
    }
}

@Composable
private fun HomeGardenSection(gardenItems: List<PlantTheme>) {
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
            .padding(bottom = 16.dp)
    ) {
        gardenItems.forEach { theme ->
            HomeGardenListItem(plantTheme = theme)
        }
    }
}

@Composable
private fun BrowseThemeSection(themes: List<PlantTheme>) {
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
        themes.forEach { theme ->
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
    val previewState = HomeViewState(
        plantThemes = defaultPlantThemes,
        homeGardenItems = homeGardenItems.take(2)
    )

    BloomTheme(darkTheme = true) {
        HomeScreenScaffold(previewState)
    }
}

@Preview
@Composable
fun PreviewLightHome() {
    val previewState = HomeViewState(
        plantThemes = defaultPlantThemes,
        homeGardenItems = homeGardenItems.take(2)
    )

    BloomTheme(darkTheme = false) {
        HomeScreenScaffold(previewState)
    }
}