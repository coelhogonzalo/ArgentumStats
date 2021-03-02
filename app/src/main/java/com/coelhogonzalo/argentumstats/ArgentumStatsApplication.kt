package com.coelhogonzalo.argentumstats

import android.app.Application
import com.coelhogonzalo.argentumstats.di.businessModule
import com.coelhogonzalo.argentumstats.di.persistenceModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level


class ArgentumStatsApplication: Application()  {

    override fun onCreate(){
        super.onCreate()

        startKoin{
            androidLogger(Level.DEBUG)
            androidContext(this@ArgentumStatsApplication)
            modules(businessModule, persistenceModule)
        }

    }
}