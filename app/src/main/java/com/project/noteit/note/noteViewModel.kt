package com.project.noteit.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.noteit.data.model.note
import com.project.noteit.data.repository.noteRepository

class noteViewModel(
    val repository: noteRepository
) : ViewModel() {

    private val _notes = MutableLiveData<List<note>>()
    val note: LiveData<List<note>>
        get() = _notes

    fun getNotes() {
        _notes.value = repository.getNotes()
    }
}