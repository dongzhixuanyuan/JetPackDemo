package com.ld.workmanager

import android.graphics.Canvas
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.*
import com.tantu.module.common.image.BitmapUtils
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var oneTimeWorkRequest =
            OneTimeWorkRequestBuilder<TestWorker>()
                .setInputData(workDataOf(ConstantKey.PARMS_B to 2,ConstantKey.PARAMS_A to 2)).build()
        var oneTimeWorkRequest2 = OneTimeWorkRequestBuilder<TestWorker02>().build()
        WorkManager.getInstance().beginUniqueWork("calculate job", ExistingWorkPolicy.REPLACE,
            oneTimeWorkRequest
        ).enqueue()

        var periodicWorkRequest = PeriodicWorkRequestBuilder<TestWorker02>(10, TimeUnit.SECONDS).build()
        WorkManager.getInstance().enqueueUniquePeriodicWork("hahah",ExistingPeriodicWorkPolicy.KEEP,periodicWorkRequest)
    }


}
