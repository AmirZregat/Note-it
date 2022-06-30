package com.project.noteit.data.repository

import com.project.noteit.data.model.note

interface noteRepository {
    fun getNotes(): List<note>
}