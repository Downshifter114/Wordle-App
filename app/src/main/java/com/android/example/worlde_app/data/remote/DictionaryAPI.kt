package com.android.example.worlde_app.data.remote

import com.android.example.worlde_app.domain.model.WordResponse
import retrofit2.http.GET

interface DictionaryAPI {

    @GET("englishwords.json")
    suspend fun getWords(): WordResponse

}