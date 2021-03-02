package com.coelhogonzalo.argentumstats.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.coelhogonzalo.argentumstats.model.Hero

@Database(entities = [Hero::class], version = 1)
abstract class ArgentumDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
}