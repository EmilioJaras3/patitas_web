package com.example.wellnessapp.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wellnessapp.data.repository.AuthRepository
import com.example.wellnessapp.domain.model.AccountType
import com.example.wellnessapp.domain.model.User
import com.example.wellnessapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    
    private val _loginState = MutableStateFlow<AuthState>(AuthState.Idle)
    val loginState: StateFlow<AuthState> = _loginState.asStateFlow()
    
    private val _registerState = MutableStateFlow<AuthState>(AuthState.Idle)
    val registerState: StateFlow<AuthState> = _registerState.asStateFlow()
    
    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()
    
    init {
        checkAuthState()
    }
    
    private fun checkAuthState() {
        viewModelScope.launch {
            authRepository.observeAuthState().collect { firebaseUser ->
                if (firebaseUser != null) {
                    loadCurrentUser(firebaseUser.uid)
                } else {
                    _currentUser.value = null
                }
            }
        }
    }
    
    private suspend fun loadCurrentUser(userId: String) {
        when (val result = authRepository.getUserProfile(userId)) {
            is Resource.Success -> {
                _currentUser.value = result.data
            }
            is Resource.Error -> {
                _currentUser.value = null
            }
            is Resource.Loading -> {}
        }
    }
    
    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = AuthState.Loading
            
            when (val result = authRepository.login(email, password)) {
                is Resource.Success -> {
                    _currentUser.value = result.data
                    _loginState.value = AuthState.Success(result.data)
                }
                is Resource.Error -> {
                    _loginState.value = AuthState.Error(result.message ?: "Error al iniciar sesión")
                }
                is Resource.Loading -> {
                    _loginState.value = AuthState.Loading
                }
            }
        }
    }
    
    fun register(
        email: String,
        password: String,
        displayName: String,
        accountType: AccountType
    ) {
        viewModelScope.launch {
            _registerState.value = AuthState.Loading
            
            when (val result = authRepository.register(email, password, displayName, accountType)) {
                is Resource.Success -> {
                    _currentUser.value = result.data
                    _registerState.value = AuthState.Success(result.data)
                }
                is Resource.Error -> {
                    _registerState.value = AuthState.Error(result.message ?: "Error al registrar")
                }
                is Resource.Loading -> {
                    _registerState.value = AuthState.Loading
                }
            }
        }
    }
    
    fun logout() {
        authRepository.logout()
        _currentUser.value = null
        _loginState.value = AuthState.Idle
        _registerState.value = AuthState.Idle
    }
    
    fun resetLoginState() {
        _loginState.value = AuthState.Idle
    }
    
    fun resetRegisterState() {
        _registerState.value = AuthState.Idle
    }
}

sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    data class Success(val user: User?) : AuthState()
    data class Error(val message: String) : AuthState()
}