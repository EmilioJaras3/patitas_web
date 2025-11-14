package com.example.wellnessapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wellnessapp.data.repository.RoutineRepository
import com.example.wellnessapp.domain.model.Routine
import com.example.wellnessapp.domain.model.RoutineCategory
import com.example.wellnessapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val routineRepository: RoutineRepository
) : ViewModel() {
    
    private val _routines = MutableStateFlow<Resource<List<Routine>>>(Resource.Loading())
    val routines: StateFlow<Resource<List<Routine>>> = _routines.asStateFlow()
    
    private val _selectedCategory = MutableStateFlow<RoutineCategory?>(null)
    val selectedCategory: StateFlow<RoutineCategory?> = _selectedCategory.asStateFlow()
    
    private val _favorites = MutableStateFlow<List<Routine>>(emptyList())
    val favorites: StateFlow<List<Routine>> = _favorites.asStateFlow()
    
    init {
        loadAllRoutines()
        loadFavorites()
    }
    
    private fun loadAllRoutines() {
        viewModelScope.launch {
            routineRepository.getAllRoutines().collect { resource ->
                _routines.value = resource
            }
        }
    }
    
    fun filterByCategory(category: RoutineCategory?) {
        _selectedCategory.value = category
        
        viewModelScope.launch {
            if (category == null) {
                loadAllRoutines()
            } else {
                routineRepository.getRoutinesByCategory(category).collect { resource ->
                    _routines.value = resource
                }
            }
        }
    }
    
    private fun loadFavorites() {
        viewModelScope.launch {
            routineRepository.getAllFavorites().collect { favoriteList ->
                _favorites.value = favoriteList
            }
        }
    }
    
    fun toggleFavorite(routine: Routine) {
        viewModelScope.launch {
            routineRepository.toggleFavorite(routine)
        }
    }
    
    fun isFavorite(routineId: String): Boolean {
        return _favorites.value.any { it.id == routineId }
    }
}