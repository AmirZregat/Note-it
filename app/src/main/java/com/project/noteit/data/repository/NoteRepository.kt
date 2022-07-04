package com.project.noteit.data.repository

import com.project.noteit.data.model.Note
import com.project.noteit.util.UiState

interface NoteRepository {
    fun getNotes(result: (UiState<List<Note>>) -> Unit)
    fun addNote(note: Note, result: (UiState<String>) -> Unit)
}