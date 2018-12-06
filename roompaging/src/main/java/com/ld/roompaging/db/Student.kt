package com.ld.roompaging.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "student",indices =[Index(value = ["address"],unique = false)] )
data class Student(
    @PrimaryKey
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    @ColumnInfo(name="number_column")
    val number: Int,
    @SerializedName("address")
    val address: String
) {
}