package com.android.example.worlde_app.domain.repository

import com.android.example.worlde_app.domain.model.Stat

interface StatRepository {

    suspend fun insertStat(stat: Stat)

    suspend fun getStatById(id: Int): Stat?

    suspend fun deleteStat(stat: Stat)
}