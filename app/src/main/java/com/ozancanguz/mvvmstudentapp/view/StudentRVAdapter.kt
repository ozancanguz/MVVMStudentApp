package com.ozancanguz.mvvmstudentapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.mvvmstudentapp.R
import com.ozancanguz.mvvmstudentapp.model.Student
import kotlinx.android.synthetic.main.student_rv_item.view.*

class StudentRVAdapter(val context: Context,
                       val noteClickDeleteInterface: NoteClickDeleteInterface,
                       val noteClickInterface: NoteClickInterface):RecyclerView.Adapter<StudentRVAdapter.studentViewHolder>() {


    class studentViewHolder(view: View) : RecyclerView.ViewHolder(view)


    // on below line we are creating a
    // variable for our all notes list.
    private val allStudents = ArrayList<Student>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): studentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_rv_item, parent, false)
        return studentViewHolder(view)

    }

    override fun onBindViewHolder(holder: studentViewHolder, position: Int) {

        // on below line we are setting data to item of recycler view.

        holder.itemView.idTVNote.setText(allStudents.get(position).name)

       holder.itemView.idTVDate.setText("Last Updated : " + allStudents.get(position).timestamp)

        holder.itemView.idIVDelete.setOnClickListener {
            // on below line we are calling a note click
            // interface and we are passing a position to it.
            noteClickDeleteInterface.onDeleteIconClick(allStudents.get(position))
        }

    }

    override fun getItemCount(): Int {
       return allStudents.size
    }
}