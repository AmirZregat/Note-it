package com.project.noteit.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.project.noteit.data.model.Note

class NoteRepositoryImp(
    val database: FirebaseFirestore
) : NoteRepository {
    override fun getNotes(): List<Note> {
        // we will get data from firebase
        return arrayListOf()
    }
}