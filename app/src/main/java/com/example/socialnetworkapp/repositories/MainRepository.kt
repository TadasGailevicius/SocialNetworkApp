package com.example.socialnetworkapp.repositories

import android.net.Uri
import com.example.socialnetworkapp.data.entities.Post
import com.example.socialnetworkapp.data.entities.User
import com.example.socialnetworkapp.other.Resource

interface MainRepository {

    suspend fun createPost(imageUri: Uri, text: String): Resource<Any>

    suspend fun getUsers(uids: List<String>): Resource<List<User>>

    suspend fun getUser(uid: String): Resource<User>

    suspend fun getPostsForFollows(): Resource<List<Post>>

    suspend fun toggleLikeForPost(post: Post): Resource<Boolean>

    suspend fun deletePost(post: Post): Resource<Post>

    suspend fun getPostsForProfile(uid: String): Resource<List<Post>>

    suspend fun toggleFollowForUser(uid: String): Resource<Boolean>
}