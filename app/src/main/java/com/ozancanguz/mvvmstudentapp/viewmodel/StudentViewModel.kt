package com.ozancanguz.mvvmstudentapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozancanguz.mvvmstudentapp.model.Student
import com.ozancanguz.mvvmstudentapp.model.StudentDatabase
import com.ozancanguz.mvvmstudentapp.model.StudentRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(application: Application):AndroidViewModel(application) {

    // on below line we are creating a variable
    // for our all notes list and repository

    val allStudents:LiveData<List<Student>>
    val repository:StudentRepository

    // on below line we are initializing
    // our dao, repository and all notes
    init {
        val dao = StudentDatabase.getDatabase(application).getStudentsDao()
        repository = StudentRepository(dao)
        allStudents = repository.allStudents
    }



    // on below line we are creating a new method for deleting a note. In this we are
    // calling a delete method from our repository to delete our note.
    fun deleteStudent (student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(student)
    }

    // on below line we are creating a new method for updating a note. In this we are
    // calling a update method from our repository to update our note.
    fun updateStudent(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(student)
    }


    // on below line we are creating a new method for adding a new note to our database
    // we are calling a method from our repository to add a new note.
    fun addStudent (student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(student)
    }





}