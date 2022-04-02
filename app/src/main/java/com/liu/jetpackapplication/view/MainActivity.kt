package com.liu.jetpackapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.liu.jetpackapplication.R
import com.liu.jetpackapplication.hilt.Truck
import com.liu.jetpackapplication.service.GithubService
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var truck: Truck
    @Inject
    lateinit var retrofit: Retrofit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        truck.deliver()
    }
}