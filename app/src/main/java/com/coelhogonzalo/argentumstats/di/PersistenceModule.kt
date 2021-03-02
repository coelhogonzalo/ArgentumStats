package com.coelhogonzalo.argentumstats.di

import androidx.room.Room
import com.coelhogonzalo.argentumstats.utils.Constants
import com.coelhogonzalo.argentumstats.persistence.ArgentumDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val persistenceModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            ArgentumDatabase::class.java,
            Constants.DATABASE_NAME
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<ArgentumDatabase>().heroDao() }

}