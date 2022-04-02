package com.liu.jetpackapplication.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class EngineModule {//不需要具体的函数体

    @BindGasEngine
    @Binds
    abstract fun bindGasEngine(gasEngine: GasEngine):Engine

    @BindElectricEngine
    @Binds
    abstract fun bindElectricEngine(gasEngine: ElectricEngine):Engine
}