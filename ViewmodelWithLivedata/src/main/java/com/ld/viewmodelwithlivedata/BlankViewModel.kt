package com.ld.viewmodelwithlivedata

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations

class BlankViewModel : ViewModel() {
    var number = MutableLiveData<Int>()
    var score = Transformations.map(number) {
            it?.times(10)
    }
}
