package com.coelhogonzalo.argentumstats

import com.coelhogonzalo.argentumstats.di.businessModule
import com.coelhogonzalo.argentumstats.di.parseRPGClasses
import com.coelhogonzalo.argentumstats.di.parseRaces
import com.coelhogonzalo.argentumstats.model.Calculator
import com.coelhogonzalo.argentumstats.model.Hero
import com.coelhogonzalo.argentumstats.model.RPGClass
import com.coelhogonzalo.argentumstats.model.Race
import com.coelhogonzalo.argentumstats.utils.Constants
import org.junit.Test

import org.junit.Assert.*
import org.koin.core.component.KoinApiExtension
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@KoinApiExtension
class ExampleUnitTest :KoinComponent {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun getAvgHealth_isCorrect() {
        startKoin {
            modules(businessModule)
        }//reemplazar con mockito
        val nila: Hero by inject { parametersOf("Nila", Constants.HUMAN, Constants.CLERIC) }
        val alkon: Calculator = get()
        assertEquals(90f, alkon.getAvgHealth(nila, 1))
        assertEquals(95.5f, alkon.getAvgHealth(nila, 2))
        assertEquals(101f, alkon.getAvgHealth(nila, 3))
        assertEquals(145f, alkon.getAvgHealth(nila, 11))
        assertEquals(90f+5.5f*44, alkon.getAvgHealth(nila, 45))
        val dira: Hero by inject { parametersOf("Dira", Constants.DARKELF, Constants.CLERIC) }
        assertEquals(70f, alkon.getAvgHealth(dira, 1))
        assertEquals(75.5f, alkon.getAvgHealth(dira, 2))
        assertEquals(81f, alkon.getAvgHealth(dira, 3))
        assertEquals(125f, alkon.getAvgHealth(dira, 11))
        assertEquals(70f+5.5f*44, alkon.getAvgHealth(dira, 45))
    }

    @Test
    fun parseRaces_isCorrect() {
        val human = Race("human", 90, 18)
        val elf = Race("elf", 70, 20)
        val darkelf = Race("darkelf", 70, 20)
        val dwarf = Race("dwarf", 110, 17)
        val gnome = Race("gnome", 50, 21)
        val racesExpected = hashMapOf<String, Race>(
                human.name to human,
                elf.name to elf,
                darkelf.name to darkelf,
                dwarf.name to dwarf,
                gnome.name to gnome
        )
        val racesActual = parseRaces()
        assertEquals(racesExpected, racesActual)
    }

    @Test
    fun parseRPGClasses_isCorrect() {
        val mage = RPGClass("mage", listOf(3, 4, 5, 6), 2f)
        val paladin = RPGClass("paladin", listOf(5, 6, 7, 8), 0.5f)
        val cleric = RPGClass("cleric", listOf(4, 5, 6, 7), 1f)
        val warrior = RPGClass("warrior", listOf(6, 7, 8, 9), 0f)
        val expectedRpgClasses = hashMapOf<String, RPGClass>(cleric.name to cleric, paladin.name to paladin,mage.name to mage,warrior.name to warrior)
        val actualRpgClasses = parseRPGClasses()
        print(expectedRpgClasses)
        print(" ")
        print(actualRpgClasses)
        assertEquals(expectedRpgClasses, actualRpgClasses)
    }
}