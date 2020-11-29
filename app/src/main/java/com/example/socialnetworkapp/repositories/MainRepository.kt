package com.example.socialnetworkapp.repositories

import android.net.Uri
import com.example.socialnetworkapp.data.entities.User
import com.example.socialnetworkapp.other.Resource

interface MainRepository {

    suspend fun createPost(imageUri: Uri, text: String): Resource<Any>

    suspend fun getUsers(uids: List<String>): Resource<List<User>>

    suspend fun getUser(uid: String): Resource<User>
}