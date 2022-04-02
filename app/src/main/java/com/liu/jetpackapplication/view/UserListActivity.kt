package com.liu.jetpackapplication.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.liu.jetpackapplication.R
import com.liu.jetpackapplication.database.AppDatabase
import com.liu.jetpackapplication.model.User
import java.util.concurrent.Executors

class UserListActivity : AppCompatActivity() {
    private val userDao by lazy {
        AppDatabase.getInstance(this).userDao()
    }

    companion object {
        const val TAG = "UserListActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        printUser()

    }

    private fun printUser() {
        userDao.getAll()?.onEach { user ->
            Log.e(TAG, user.toString())
        }
    }
}