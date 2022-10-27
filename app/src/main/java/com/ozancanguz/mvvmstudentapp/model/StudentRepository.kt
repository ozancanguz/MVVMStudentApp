package com.ozancanguz.mvvmstudentapp.model

import androidx.lifecycle.LiveData

class StudentRepository(private val studentsDao:StudentDao) {



    // on below line we are creating a variable for our list
    // and we are getting all the notes from our DAO class.
    val allStudents:LiveData<List<Student>> =studentsDao.getAllStudents()


    // on below line we are creating an insert method
    // for adding the note to our database.
    suspend fun insert(student: Student){
        studentsDao.insert(student)
    }

    // on below line we are creating a delete method
    // for deleting our note from database.
    suspend fun delete(student:Student){
        studentsDao.delete(student)
    }

    // on below line we are creating a update method for
    // updating our note from database.
    suspend fun update(student: Student){
        studentsDao.update(student)
    }


}