package com.liu.jetpackapplication.hilt

import android.util.Log
import javax.inject.Inject

class Truck @Inject constructor(private val driver: Driver) {
    //    val computer1=Computer()
//    val computer2=Computer()
    lateinit var carGos: List<CarGo>
    @BindGasEngine
    @Inject
    lateinit var gasEngine: Engine

    @BindElectricEngine
    @Inject
    lateinit var electricEngine: Engine

    fun deliver() {
        gasEngine.start()
        electricEngine.start()
        Log.e("Truck", "truck is delivering cargo , driven by $driver")
        gasEngine.shutdown()
        electricEngine.shutdown()
//       loadToTruck(computer1)
//       loadToTruck(computer2)

//        carGos.forEach {
//            loadToTruck(it)
//        }

    }

    private fun loadToTruck(computer: Computer) {

    }

    private fun loadToTruck(carGo: CarGo) {

    }

    fun beginToDeliver() {

    }
}