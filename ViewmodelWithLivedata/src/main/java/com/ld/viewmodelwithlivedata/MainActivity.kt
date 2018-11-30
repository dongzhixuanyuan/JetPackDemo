package com.ld.viewmodelwithlivedata

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ld.viewmodelwithlivedata.R

class MainActivity : AppCompatActivity() {

    private lateinit var blankViewModel:BlankViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        blankViewModel = ViewModelProviders.of(this).get(BlankViewModel::class.java)

    }



}
