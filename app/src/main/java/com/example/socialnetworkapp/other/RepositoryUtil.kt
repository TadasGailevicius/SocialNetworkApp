package com.example.socialnetworkapp.other

import com.google.firebase.firestore.FirebaseFirestoreException
import java.lang.Exception

inline fun <T> safeCall(action: () -> Resource<T>) : Resource<T> {
    return try {
        action()
    } catch (e: Exception){
        Resource.Error(e.localizedMessage ?: "An unknown error occured")
    }
}