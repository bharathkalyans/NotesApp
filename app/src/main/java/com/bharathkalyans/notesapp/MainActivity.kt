package com.bharathkalyans.notesapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bharathkalyans.notesapp.data.Note
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), INotesRVAdapter {

    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NoteAdapter(this, this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModel::class.java)

        viewModel.allNotes.observe(this, { list ->
            list?.let {
                adapter.updateList(list)
            }
        })
    }

    override fun onItemClicked(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(this, "${note.text} deleted!", Toast.LENGTH_SHORT).show()
    }

    fun insertNote(view: View) {
        val inputNote = etInputNote.text.toString()
        if (inputNote.isNotEmpty()) {
            val note = Note(0,inputNote)
            viewModel.insertNote(note)
            Toast.makeText(this, "${note.text} added!", Toast.LENGTH_SHORT).show()
        }
    }

}