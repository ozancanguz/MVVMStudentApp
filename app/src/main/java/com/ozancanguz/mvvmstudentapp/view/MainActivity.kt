package com.ozancanguz.mvvmstudentapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.ozancanguz.mvvmstudentapp.R
import com.ozancanguz.mvvmstudentapp.model.Student
import com.ozancanguz.mvvmstudentapp.viewmodel.StudentViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , NoteClickInterface, NoteClickDeleteInterface{


    // on below line we are creating a variable
    // for our recycler view, exit text, button and viewmodel.
    lateinit var viewModel: StudentViewModel
    lateinit var studentRV: RecyclerView
    lateinit var addFAB: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // on below line we are initializing
        // all our variables.
        studentRV = StudentRV
        addFAB = findViewById(R.id.idFAB)

        // on below line we are setting layout
        // manager to our recycler view.
        studentRV.layoutManager = LinearLayoutManager(this)

// on below line we are initializing our adapter class.
        val studentRVAdapter = StudentRVAdapter(this, this, this)

        // on below line we are setting
        // adapter to our recycler view.
        studentRV.adapter = studentRVAdapter

        // on below line we are
        // initializing our view modal.
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(StudentViewModel::class.java)

// on below line we are calling all notes method
        // from our view modal class to observer the changes on list.
        viewModel.allStudents.observe(this, Observer { list ->
            list?.let {
                // on below line we are updating our list.
                studentRVAdapter.updateList(it)
            }
        })
        addFAB.setOnClickListener {
            // adding a click listener for fab button
            // and opening a new intent to add a new note.
            val intent = Intent(this@MainActivity, AddEditStudentActivity::class.java)
            startActivity(intent)
            this.finish()
        }


    }

    override fun onNoteClick(student: Student) {
        // opening a new intent and passing a data to it.
        val intent = Intent(this@MainActivity, AddEditStudentActivity::class.java)
        intent.putExtra("studentType", "Edit")
        intent.putExtra("noteTitle", student.name)
        intent.putExtra("studentDescription", student.description)
        intent.putExtra("studentId", student.id)
        startActivity(intent)
        this.finish()
    }
    override fun onDeleteIconClick(student: Student) {
        // in on note click method we are calling delete
        // method from our view modal to delete our not.
        viewModel.deleteStudent(student)
        // displaying a toast message
    }




    }
