package com.example.socialnetworkapp.ui.auth

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ServiceLifecycleDispatcher
import androidx.lifecycle.ViewModel
import com.example.socialnetworkapp.repositories.AuthRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class AuthViewModel @ViewModelInject constructor(
        private val repository: AuthRepository,
        private val applicationContext: ApplicationContext,
        private val dispatcher: CoroutineDispatcher = Dispatchers.Main

) : ViewModel() {
}