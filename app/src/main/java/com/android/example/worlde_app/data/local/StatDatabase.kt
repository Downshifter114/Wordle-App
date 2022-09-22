package com.android.example.worlde_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.example.worlde_app.domain.model.Stat

@Database(
    entities = [Stat::class],
    version = 1
)
abstract class StatDatabase : RoomDatabase() {

    abstract val dao: StatDao

    companion object {
        const val DATABASE_NAME = "stat_db"
    }
}