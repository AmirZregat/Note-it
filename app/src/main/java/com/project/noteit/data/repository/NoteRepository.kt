package com.project.noteit.data.repository

import com.project.noteit.data.model.Note

interface NoteRepository {
    fun getNotes(): List<Note>
}