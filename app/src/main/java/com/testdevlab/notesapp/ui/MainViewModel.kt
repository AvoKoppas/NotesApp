package com.testdevlab.notesapp.ui

import androidx.lifecycle.ViewModel
import com.testdevlab.App
import com.testdevlab.notesapp.common.launchIO
import com.testdevlab.notesapp.repository.NoteRepository
import com.testdevlab.notesapp.repository.models.NoteItem
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class MainViewModel : ViewModel() {

    @Inject
    lateinit var repository: NoteRepository

    private val _notes = MutableSharedFlow<List<NoteItem>>(replay = 1)
    val notes: SharedFlow<List<NoteItem>> = _notes

    var selectedNote: NoteItem? = null

    init {
        App.component.inject(this)
        launchIO {
            repository.notes.collect { notes ->
                _notes.tryEmit(notes)
            }
        }
    }

    fun addNote(title: String, text: String) = launchIO {
        val id = _notes.replayCache.lastOrNull()?.maxOfOrNull { it.id }?.plus(1) ?: 0
        repository.insertNote(NoteItem(id, title, text))
    }

    fun deleteNote() = launchIO {
        selectedNote?.let { note ->
            repository.deleteNote(note)
        }
    }
}