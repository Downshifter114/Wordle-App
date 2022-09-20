package com.android.example.worlde_app.data.repository

import com.android.example.worlde_app.data.remote.DictionaryAPI
import com.android.example.worlde_app.domain.model.WordResponse
import com.android.example.worlde_app.domain.repository.DictionaryRepository
import java.lang.Exception
import javax.inject.Inject

class DictionaryRepositoryImpl @Inject constructor(
    private val api: DictionaryAPI
) : DictionaryRepository {
    override suspend fun getWords(): WordResponse {
        return try {
            api.getWords()
        }
        catch (e: Exception) {
            e.printStackTrace()
            WordResponse()
        }

    }
}