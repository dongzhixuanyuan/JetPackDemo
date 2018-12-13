package com.ld.roompaging.db

import android.arch.persistence.room.*
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
)

@Entity()
data class Person(@PrimaryKey var name: String, var pets:List<Pet>)

@Entity(foreignKeys = arrayOf(ForeignKey(entity = Person::class, parentColumns = arrayOf("name"), childColumns = arrayOf("ownerId"))))
data class Pet(@PrimaryKey var size:Int,var ownerId:String)

