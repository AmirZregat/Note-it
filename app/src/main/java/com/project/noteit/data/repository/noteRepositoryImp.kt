package com.project.noteit.data.repository

import com.project.noteit.data.model.note

class noteRepositoryImp : noteRepository {
    override fun getNotes(): List<note> {
        // we will get data from firebase
        return arrayListOf()
    }
}