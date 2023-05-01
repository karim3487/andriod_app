package com.example.myapplication

import android.app.Application

class App : Application() {
    val newsService = NewsService()
}