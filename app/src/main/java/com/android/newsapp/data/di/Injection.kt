package com.android.newsapp.data.di

import android.content.Context
import com.android.newsapp.data.local.room.NewsDatabase
import com.android.newsapp.data.remote.retrofit.ApiConfig
import com.android.newsapp.data.remote.retrofit.ApiService
import com.android.newsapp.data.source.NewsRepository
import com.android.newsapp.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): NewsRepository {
        val apiService = ApiConfig.getApiService()
        val database = NewsDatabase.getInstance(context)
        val dao = database.newsDao()
        val appExecutors = AppExecutors()
        return NewsRepository.getInstance(apiService, dao, appExecutors)
    }
}