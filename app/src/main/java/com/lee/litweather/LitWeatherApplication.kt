package com.lee.litweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class LitWeatherApplication :Application() {

    companion object{
        const val TOKEN = "HOEWwZqPsqgacYp4"
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}