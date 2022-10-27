package com.ozancanguz.mvvmstudentapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "students_table")
class Student (

    @ColumnInfo(name = "name")
    var name:String,

    @ColumnInfo(name = "description")
    var description:String,

    @ColumnInfo(name="timestamp")
    var timestamp:String
        ){
    @PrimaryKey(autoGenerate = true)
    var id = 0
}

