package com.liu.jetpackapplication.hilt

import javax.inject.Inject
import javax.inject.Qualifier

class ElectricEngine @Inject constructor() : Engine {
    override fun start() {
        println("Electric engine start.")
    }

    override fun shutdown() {
        println("Electric engine shutdown.")
    }

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindElectricEngine