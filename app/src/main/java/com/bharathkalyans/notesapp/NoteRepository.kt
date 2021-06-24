package com.bharathkalyans.notesapp

import androidx.lifecycle.LiveData
import com.bharathkalyans.notesapp.data.Note
import com.bharathkalyans.notesapp.data.NoteDao

class NoteRepository(private val noteDao: NoteDao) {


    val getAllNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

}