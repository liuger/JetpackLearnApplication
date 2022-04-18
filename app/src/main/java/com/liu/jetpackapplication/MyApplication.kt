package com.liu.jetpackapplication

import android.app.Application
import androidx.startup.AppInitializer
import dagger.hilt.android.HiltAndroidApp
import retrofit2.Response.error
import java.io.Console

@HiltAndroidApp
class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
//        AppInitializer.getInstance(applicationContext).initializeComponent(StartupLibInitializer::class.java)
    }
}