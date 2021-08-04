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
