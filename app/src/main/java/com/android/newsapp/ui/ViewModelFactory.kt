package com.android.newsapp.ui

import android.content.Context
import android.widget.ViewSwitcher.ViewFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.newsapp.data.di.Injection
import com.android.newsapp.data.source.NewsRepository

class ViewModelFactory private constructor(private val newsRepository: NewsRepository) : ViewModelProvider.NewInstanceFactory(){
    @Suppress("UCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java)){
            return NewsViewModel(newsRepository) as T
        }
        throw IllegalArgumentException("Unknouwn ViewModel class" + modelClass.name)
    }
    companion object{
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this){
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }.also { instance = it }

    }
}