package com.ld.roompaging.db

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface StudentQueryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(students: List<Student>): Unit

    @Query("SELECT * FROM student WHERE name LIKE :queryName  ORDER BY number_column ASC")
    fun queryByName(queryName: String): DataSource.Factory<Int, Student>
}