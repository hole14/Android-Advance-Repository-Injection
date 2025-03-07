package com.android.newsapp.ui

import androidx.lifecycle.ViewModel
import com.android.newsapp.data.source.NewsRepository

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    fun getHeadlineNews() = newsRepository.getHeadlineNews()
}