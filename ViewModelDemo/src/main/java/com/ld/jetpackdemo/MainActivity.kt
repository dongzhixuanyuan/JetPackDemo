package com.ld.jetpackdemo

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import me.ele.uetool.UETool

class MainActivity : AppCompatActivity() {

    private lateinit var blankViewModel:BlankViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        blankViewModel = ViewModelProviders.of(this).get(BlankViewModel::class.java)

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        UETool.showUETMenu()
    }

}
