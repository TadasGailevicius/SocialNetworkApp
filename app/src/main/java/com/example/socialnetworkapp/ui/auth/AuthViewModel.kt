package com.example.socialnetworkapp.ui.auth

import android.content.Context
import android.util.Patterns
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.socialnetworkapp.R
import com.example.socialnetworkapp.other.Constants.MAX_USERNAME_LENGHT
import com.example.socialnetworkapp.other.Constants.MIN_PASSWORD_LENGHT
import com.example.socialnetworkapp.other.Constants.MIN_USERNAME_LENGHT
import com.example.socialnetworkapp.other.Event
import com.example.socialnetworkapp.other.Resource
import com.example.socialnetworkapp.repositories.AuthRepository
import com.google.firebase.auth.AuthResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthViewModel @ViewModelInject constructor(
        private val repository: AuthRepository,
        private val applicationContext: Context,
        private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel() {

    private val _registerStatus = MutableLiveData<Event<Resource<AuthResult>>>()
    val registerStatus: LiveData<Event<Resource<AuthResult>>> = _registerStatus

    fun register(email: String, username: String, password: String, repeatedPassword: String){
        val error = if(email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            applicationContext.getString(R.string.error_input_empty)
        } else if(password != repeatedPassword){
            applicationContext.getString(R.string.error_incorrectly_repeated_password)
        } else if(username.length < MIN_USERNAME_LENGHT){
            applicationContext.getString(R.string.error_username_too_short, MIN_USERNAME_LENGHT)
        } else if(username.length > MAX_USERNAME_LENGHT){
            applicationContext.getString(R.string.error_username_too_long, MAX_USERNAME_LENGHT)
        } else if (password.length < MIN_PASSWORD_LENGHT){
            applicationContext.getString(R.string.error_password_too_short)
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            applicationContext.getString(R.string.error_not_a_valid_email)
        } else null

        error?.let {
            _registerStatus.postValue(Event(Resource.Error(it)))
            return
        }

        _registerStatus.postValue(Event(Resource.Loading()))
        viewModelScope.launch {
            val result = repository.register(email,username,password)
            _registerStatus.postValue(Event(result))
        }
    }
}