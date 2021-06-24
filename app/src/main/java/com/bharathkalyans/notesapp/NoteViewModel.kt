package com.bharathkalyans.notesapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.bharathkalyans.notesapp.data.Note
import com.bharathkalyans.notesapp.data.NoteDatabase

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes: LiveData<List<Note>>

    init {
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        val repository = NoteRepository(dao)
        allNotes = repository.getAllNotes
    }

}