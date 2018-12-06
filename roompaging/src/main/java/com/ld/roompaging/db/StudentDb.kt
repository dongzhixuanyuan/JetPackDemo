package com.ld.roompaging.db

import android.arch.persistence.db.SupportSQLiteOpenHelper
import android.arch.persistence.room.Database
import android.arch.persistence.room.DatabaseConfiguration
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(Student::class),version = 1,exportSchema = false)
abstract class StudentDb : RoomDatabase() {
    companion object {
        fun create(context: Context, useInmemory: Boolean = false): StudentDb {
            val databaseBuilder = if (useInmemory) {
                Room.inMemoryDatabaseBuilder(context, StudentDb::class.java)
            } else {
                Room.databaseBuilder(context,StudentDb::class.java,"student.db")
            }

            return databaseBuilder.fallbackToDestructiveMigration()
                .allowMainThreadQueries().build()
        }
    }
    abstract fun getStudentDao():StudentQueryDao
}