package com.ld.roompaging

import android.arch.lifecycle.*
import android.arch.paging.PagedList
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.ld.roompaging.R.id.student_list
import com.ld.roompaging.db.Student
import com.ld.roompaging.db.StudentDb
import com.ld.roompaging.paging.StudentPagelistAdapter
import com.ld.roompaging.paging.StudentRepository
import com.ld.roompaging.paging.StudentViewmodel
import com.tantu.module.common.thread.UiThread
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var studentPagelistAdapter: StudentPagelistAdapter
    private lateinit var studentViewmodel: StudentViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StudentDb.create(applicationContext, false)
        StudentRepository.instance(context = applicationContext).addStudents(generateTest())
        initadapter()
        initviewmodel()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        studentViewmodel.query("abc815")
        UiThread.runLater({
            studentViewmodel.updateItem(Student("abc815",100,"我的家"))
        },3000)

    }

    private fun initviewmodel() {
        studentViewmodel = ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                var studentViewmodel = StudentViewmodel(StudentRepository.instance(context = applicationContext))
                return studentViewmodel as T
            }

        })[StudentViewmodel::class.java]
        studentViewmodel.result.observe(this, object : Observer<PagedList<Student>> {
            override fun onChanged(t: PagedList<Student>?) {
                studentPagelistAdapter.submitList(t)
            }
        })
        student_list.adapter = studentPagelistAdapter
    }

    private fun initadapter() {
        studentPagelistAdapter = StudentPagelistAdapter()
//        这个Layout manager可不能忘了啊，不然数据出不来
        student_list.layoutManager = LinearLayoutManager(this)
    }


    private fun generateTest(): List<Student> {
        var list = arrayListOf<Student>()
        var namePrefix = "abc"
        var addressPrefix = "address"
        for (m in 0..1000) {
            val number = (Math.random() * 20000).toInt()
            var student = Student(namePrefix + m.toString(), number, addressPrefix + m.toString())
            list.add(student)
//            Log.d(javaClass.simpleName, student.toString())
        }
        return list
    }
}
