package com.android.example.worlde_app.data.repository

import com.android.example.worlde_app.data.local.StatDao
import com.android.example.worlde_app.domain.model.Stat
import com.android.example.worlde_app.domain.repository.StatRepository
import javax.inject.Inject

class StatRepositoryImpl @Inject constructor(
    private val dao: StatDao
): StatRepository {
    override suspend fun insertStat(stat: Stat) {
        dao.insertStat(stat)
    }

    override suspend fun getStatById(id: Int): Stat? {
        return dao.getStatById(id)
    }

    override suspend fun deleteStat(stat: Stat) {
        dao.deleteStat(stat)
    }
}