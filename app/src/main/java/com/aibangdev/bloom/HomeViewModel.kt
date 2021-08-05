package com.aibangdev.bloom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: PlantRepository
) : ViewModel() {

    private val _viewState = MutableStateFlow(HomeViewState())
    val viewState : StateFlow<HomeViewState> = _viewState

    init {
        fetchPlantThemes()
        fetchHomeGardenItems()
    }

    private fun fetchPlantThemes(){
        viewModelScope.launch {
            val plantThemes = repository.fetchThemes()

            _viewState.value = _viewState.value.copy(
                plantThemes = plantThemes
            )
        }
    }

    private fun fetchHomeGardenItems(){
        viewModelScope.launch {
            val homeGardenItems = repository.fetchHomeGardenItems()

            _viewState.value = _viewState.value.copy(
                homeGardenItems = homeGardenItems
            )
        }
    }

}

data class HomeViewState(
    val plantThemes: List<PlantTheme> = emptyList(),
    val homeGardenItems: List<PlantTheme> = emptyList(),
)