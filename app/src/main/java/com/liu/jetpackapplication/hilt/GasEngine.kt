package com.liu.jetpackapplication.hilt

import android.util.Log
import javax.inject.Inject
import javax.inject.Qualifier

class GasEngine @Inject constructor() :Engine {
    override fun start() {
        Log.e("Engine","Gas engine start.")
    }

    override fun shutdown() {
        Log.e("Engine","Gas engine shutdown.")
    }

}
@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindGasEngine