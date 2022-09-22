package com.android.example.worlde_app.data.local

import androidx.room.*
import com.android.example.worlde_app.domain.model.Stat

@Dao
interface StatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStat(stat: Stat)

    @Query("SELECT * FROM stat WHERE id = :id")
    suspend fun getStatById(id: Int): Stat?

    @Delete
    suspend fun deleteStat(stat: Stat)
}