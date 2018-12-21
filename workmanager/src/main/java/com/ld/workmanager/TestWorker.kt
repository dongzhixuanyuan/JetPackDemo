package com.ld.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.tantu.module.common.BaseApplication
import com.tantu.module.common.system.ToastUtil
import com.tantu.module.common.thread.UiThread


object ConstantKey {
    const val PARAMS_A = "key_a"
    const val PARMS_B = "key_b"
    const val RESULT = "result"
}

class TestWorker(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    override fun doWork(): Result {
        var a = inputData.getInt(ConstantKey.PARAMS_A, -1)
        var b = inputData.getInt(ConstantKey.PARMS_B, -1)
        Log.d("liudong", "a $a,b: $b")
        if (a == -1 || b == -1) {
            return Result.failure()
        }
        var result = 0
        for (i in 1..100000) {
            result += a
            result += b
        }
        return Result.success(workDataOf(ConstantKey.RESULT to result))
    }
}


class TestWorker02(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    override fun doWork(): Result {
//        var indata = inputData.getInt(ConstantKey.RESULT, 100)
        Log.d("liudong","ffff")
        return Result.success()
    }

}