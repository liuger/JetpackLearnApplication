package com.liu.jetpackapplication.view

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.liu.jetpackapplication.R
import com.liu.jetpackapplication.worker.MyWorker
import java.util.concurrent.TimeUnit

class WorkerActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker)
        val constraints = Constraints.Builder().setRequiresDeviceIdle(false)//出发时设备是否为空闲
            .setRequiresCharging(false)//触发时设备是否充电
            .setRequiredNetworkType(NetworkType.UNMETERED)//触发时网络状态
            .setRequiresBatteryNotLow(false)//指定设备电池是否不应低于临界阈值
            .setRequiresStorageNotLow(false)//指定设备可用存储是否不应低于临界阈值
            .build()
        val oneTimeWorkRequest = OneTimeWorkRequest.Builder(MyWorker::class.java)
            .setInitialDelay(2, TimeUnit.SECONDS)//设置延时
            .setBackoffCriteria(BackoffPolicy.LINEAR, 2, TimeUnit.SECONDS)//重新执行任务
            .setInputData(Data.Builder().putInt("param1", 1).putString("param2", "2").build())//传值
            .setConstraints(constraints)
            .build()
        val btnStart = findViewById<Button>(R.id.btn_start)
        val btnCancel = findViewById<Button>(R.id.btn_cancel)
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneTimeWorkRequest.id).observe(this) {
            if (it != null) {
                val progress = it.progress.getInt("PROGRESS", 0)
                if (progress > 0) Log.e("MyWorker", "progress:$progress")
                val data = it.outputData

                when (it.state) {
                    WorkInfo.State.SUCCEEDED -> {
                        Log.e("MainState", "成功");
                        Log.e(
                            "MyWorker",
                            "outputData:param3=${
                                data.getInt(
                                    "param3",
                                    0
                                )
                            },param4=${data.getString("param4")}"
                        )
                    }
                    WorkInfo.State.FAILED -> {
                        Log.e("MainState", "失败");
                    }
                    WorkInfo.State.CANCELLED -> {
                        Log.e("MainState", "取消");
                    }
                }
            }

        }
        btnStart.setOnClickListener {
            Log.e("MyWorker", "click")
            WorkManager.getInstance(this).enqueue(oneTimeWorkRequest)
        }
        btnCancel.setOnClickListener {
            WorkManager.getInstance(this).cancelWorkById(oneTimeWorkRequest.id)
        }
    }
}