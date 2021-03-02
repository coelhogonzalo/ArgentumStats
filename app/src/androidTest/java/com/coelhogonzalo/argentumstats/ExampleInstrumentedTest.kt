package com.coelhogonzalo.argentumstats

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.coelhogonzalo.argentumstats.model.Hero
import com.coelhogonzalo.argentumstats.persistence.ArgentumDatabase
import com.coelhogonzalo.argentumstats.utils.Constants

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@KoinApiExtension
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest :KoinComponent {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.coelhogonzalo.argentumstats", appContext.packageName)
    }
    @Test
    fun database_isWorking(){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.coelhogonzalo.argentumstats", appContext.packageName)
        val database: ArgentumDatabase = get()
        val nila: Hero by inject { parametersOf("Nila", Constants.HUMAN, Constants.CLERIC) }
        val dira: Hero by inject { parametersOf("Dira", Constants.DARKELF, Constants.CLERIC) }
        database.heroDao().insertHero(nila)
        Log.d("Database test",database.heroDao().getAllHeroes().toString())
        database.heroDao().insertHero(dira)
        Log.d("Database test",database.heroDao().getAllHeroes().toString())
        database.heroDao().delete(nila)
        Log.d("Database test",database.heroDao().getAllHeroes().toString())
        database.heroDao().deleteAll()
        Log.d("Database test",database.heroDao().getAllHeroes().toString())
    }
}