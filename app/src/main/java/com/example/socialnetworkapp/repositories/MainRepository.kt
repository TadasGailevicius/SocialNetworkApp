package com.example.socialnetworkapp.repositories

import android.net.Uri
import com.example.socialnetworkapp.other.Resource

interface MainRepository {

    suspend fun  createPost(imageUri: Uri, text: String): Resource<Any>
}