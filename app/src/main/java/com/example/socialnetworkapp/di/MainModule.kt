package com.example.socialnetworkapp.di

import com.example.socialnetworkapp.repositories.AuthRepository
import com.example.socialnetworkapp.repositories.DefaultMainRepository
import com.example.socialnetworkapp.repositories.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent:: class)
object MainModule {

    @ActivityScoped
    @Provides
    fun provideMainRepository() = DefaultMainRepository() as MainRepository

}