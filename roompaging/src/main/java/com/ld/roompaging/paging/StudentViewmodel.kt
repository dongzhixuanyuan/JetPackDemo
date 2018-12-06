package com.ld.roompaging.paging

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel

class StudentViewmodel(val repository: StudentRepository) : ViewModel() {
    private val queryName = MutableLiveData<String>()
    public val result = Transformations.switchMap(queryName){
        repository.queryStudent(it,20,null)
    }

    fun query(name: String) {
        if (name == queryName.value) {
            return
        }
        queryName.value = name
    }
}