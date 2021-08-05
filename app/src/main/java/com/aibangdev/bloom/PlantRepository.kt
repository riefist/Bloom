package com.aibangdev.bloom

interface PlantRepository {

    suspend fun fetchThemes(): List<PlantTheme>
    suspend fun fetchHomeGardenItems(): List<PlantTheme>

}