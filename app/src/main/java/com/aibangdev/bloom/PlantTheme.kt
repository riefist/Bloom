package com.aibangdev.bloom

data class PlantTheme(
    val imageRes: Int,
    val title: String
)

val defaultPlantThemes = listOf(
    PlantTheme(R.drawable.desert_chic, "Desert Chic"),
    PlantTheme(R.drawable.tiny_terrariums, "Tiny Terrariums"),
    PlantTheme(R.drawable.jungle_vibes, "Jungle Vibes"),
    PlantTheme(R.drawable.easy_care, "Easy Care"),
    PlantTheme(R.drawable.statements, "Statements")
)

val homeGardenItems = listOf(
    PlantTheme(R.drawable.monstera, "Monstera"),
    PlantTheme(R.drawable.aglaonema, "Aglaonema"),
    PlantTheme(R.drawable.peace_lily, "Peace Lily"),
    PlantTheme(R.drawable.fiddle_leaf, "Fiddle Leaf"),
    PlantTheme(R.drawable.snake_plant, "Snake Plant"),
    PlantTheme(R.drawable.pothos, "Pothos")
)