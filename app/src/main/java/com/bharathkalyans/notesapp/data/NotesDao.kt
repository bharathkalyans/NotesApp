package com.bharathkalyans.notesapp.data

import androidx.room.*

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNote(note: Note)

    @Delete
    fun deleteNote()

    @Query("SELECT * FROM NOTES_TABLE ORDER BY id ASC")
    fun getAllNotes(): List<Note>



}