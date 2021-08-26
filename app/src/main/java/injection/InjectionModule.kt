package com.testdevlab.notesapp.injection

import android.content.Context
import androidx.room.Room
import com.testdevlab.notesapp.common.NOTE_DATABASE_NAME
import com.testdevlab.notesapp.repository.NoteRepository
import com.testdevlab.notesapp.repository.cache.NoteDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InjectionModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideNoteDataBase() = Room
        .databaseBuilder(context, NoteDatabase::class.java, NOTE_DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideNoteRepository(database: NoteDatabase) = NoteRepository(database.noteDao())
}