package com.liu.jetpackapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*

class LifecycleTestActivity : AppCompatActivity() {
    companion object {
        const val TAG = "LifecycleTest"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(MyObverse())
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ");
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: ");
    }

}

class MyObverse : DefaultLifecycleObserver {
    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        Log.i(LifecycleTestActivity.TAG, "MyObverse onResume: ");
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.i(LifecycleTestActivity.TAG, "MyObverse onPause: ");


    }

}