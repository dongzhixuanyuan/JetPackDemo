package com.ld.roompaging.db

import android.arch.paging.DataSource
import android.arch.persistence.room.*

@Dao
interface StudentQueryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(students: List<Student>): Unit

    @Query("SELECT * FROM student WHERE name LIKE :queryName  ORDER BY number_column ASC")
    fun queryByName(queryName: String): DataSource.Factory<Int, Student>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateStudentByName(student: Student)


}