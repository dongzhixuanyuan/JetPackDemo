package com.ld.roompaging.paging

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.content.Context
import com.ld.roompaging.db.Student
import com.ld.roompaging.db.StudentDb

class StudentRepository(private val db: StudentDb) {
    companion object {
        private val LOCK = Any()
        private var instance: StudentRepository? = null
        @Synchronized
        fun instance(context: Context): StudentRepository {
            if (instance == null) {
                instance = StudentRepository(StudentDb.create(context.applicationContext, false))
            }
            return instance!!
        }
    }
    fun queryStudent(name:String,size:Int,boundaryCallback: PagedList.BoundaryCallback<Student>?):LiveData<PagedList<Student>>{
        val results = db.getStudentDao().queryByName(name)
        return LivePagedListBuilder<Int, Student>(results, 10)
            .setBoundaryCallback(boundaryCallback).build()
    }

    fun addStudents(students:List<Student>){
        db.getStudentDao().insert(students)
    }

    fun updateStudent(student: Student) {
        db.getStudentDao().updateStudentByName(student)
    }

}