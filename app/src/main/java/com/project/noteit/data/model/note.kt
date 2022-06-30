package com.project.noteit.data.model

import com.google.firebase.firestore.ServerTimestamp
import java.util.*

data class note(
    val id: String,
    val text: String,
    @ServerTimestamp
    val date: Date,
)
