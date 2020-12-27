package com.example.socialnetworkapp.ui.main.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.socialnetworkapp.data.entities.Post
import com.example.socialnetworkapp.data.pagingsource.FollowPostsPagingSource
import com.example.socialnetworkapp.other.Constants.PAGE_SIZE
import com.example.socialnetworkapp.other.Event
import com.example.socialnetworkapp.other.Resource
import com.example.socialnetworkapp.repositories.MainRepository
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel @ViewModelInject constructor(
    private val repository: MainRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : BasePostViewModel(repository,dispatcher) {

    val pagingFlow = Pager(PagingConfig(PAGE_SIZE)){
        FollowPostsPagingSource(FirebaseFirestore.getInstance())
    }.flow.cachedIn(viewModelScope)


}