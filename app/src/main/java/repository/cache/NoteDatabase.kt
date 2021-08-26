package com.testdevlab.notesapp.repository.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.testdevlab.notesapp.repository.models.NoteItem

@Database(entities = [NoteItem::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

}