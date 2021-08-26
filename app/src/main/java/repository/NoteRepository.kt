package com.testdevlab.notesapp.repository

import com.testdevlab.notesapp.repository.cache.NoteDao
import com.testdevlab.notesapp.repository.models.NoteItem

class NoteRepository(private val noteDao: NoteDao) {

    val notes = noteDao.getNotes()

    fun insertNote(noteItem: NoteItem) = noteDao.insertNote(noteItem)

    fun deleteNote(noteItem: NoteItem) = noteDao.deleteNote(noteItem)
}