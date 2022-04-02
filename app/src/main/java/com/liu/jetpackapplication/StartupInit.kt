package com.liu.jetpackapplication

import android.content.Context
import android.util.Log

object StartupInit {
    var context: Context? = null
    fun init(context: Context): StartupInit {
        Log.e("StartupInit", "StartupInit init")
        this.context = context
        return this
    }
}