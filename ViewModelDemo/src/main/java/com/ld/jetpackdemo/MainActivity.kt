package com.ld.jetpackdemo

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import me.ele.uetool.UETool

class MainActivity : AppCompatActivity() {

    private lateinit var blankViewModel:BlankViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        blankViewModel = ViewModelProviders.of(this).get(BlankViewModel::class.java)
        Log.d(MainActivity::class.simpleName,blankViewModel.number.toString())
    }
}
