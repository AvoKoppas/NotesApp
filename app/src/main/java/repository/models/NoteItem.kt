package com.testdevlab.notesapp.repository.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.testdevlab.notesapp.common.NOTE_TABLE_NAME

@Entity(tableName = NOTE_TABLE_NAME)
data class NoteItem(
    @PrimaryKey val id: Int,
    val title: String,
    val text: String
)
