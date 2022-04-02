package com.liu.jetpackapplication.worker

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

const val PROGRESS = "PROGRESS"

class MyWorker(private val context: Context, private val workerParameters: WorkerParameters) :
    Worker(context, workerParameters) {
    init {
        setProgressAsync(Data.Builder().putInt(PROGRESS, 10).build())
    }

    override fun doWork(): Result {
        Log.e("MyWorker", "do work")
        Log.e("MyWorker", "inputData:param1=${inputData.getInt("param1",0)},param2=${inputData.getString("param2")}")
        setProgressAsync(Data.Builder().putInt(PROGRESS, 40).build());
        Thread.sleep(1000L);
        setProgressAsync(Data.Builder().putInt(PROGRESS, 60).build());
        Thread.sleep(1000L);
        setProgressAsync(Data.Builder().putInt(PROGRESS, 80).build());
        Thread.sleep(1000L);
        setProgressAsync(Data.Builder().putInt(PROGRESS, 100).build());

        return Result.success(Data.Builder().putInt("param3", 3).putString("param4", "4").build())
    }
}