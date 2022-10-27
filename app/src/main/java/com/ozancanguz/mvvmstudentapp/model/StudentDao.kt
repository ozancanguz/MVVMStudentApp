package com.ozancanguz.mvvmstudentapp.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)


    @Delete
    suspend fun delete(student: Student)

    @Update
    suspend fun update(student: Student)


    @Query("Select * from students_table order by id ASC")
    fun getAllStudents(): LiveData<List<Student>>


}