package com.bharathkalyans.notesapp.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM NOTES_TABLE ORDER BY id ASC")
    fun getAllNotes(): LiveData<List<Note>>


}