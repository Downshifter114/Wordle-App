package com.android.example.worlde_app.domain.repository

import com.android.example.worlde_app.domain.model.WordResponse

interface DictionaryRepository {
    suspend fun getWords() : WordResponse
}