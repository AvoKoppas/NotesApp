package com.testdevlab.notesapp.repository.cache

import androidx.room.*
import com.testdevlab.notesapp.repository.models.NoteItem
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table")
    fun getNotes(): Flow<List<NoteItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteItem: NoteItem)

    @Delete
    fun deleteNote(noteItem: NoteItem)

}
