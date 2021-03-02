package com.coelhogonzalo.argentumstats.di

import com.coelhogonzalo.argentumstats.model.*
import com.coelhogonzalo.argentumstats.utils.Constants
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import org.koin.dsl.module


val businessModule = module {

    single<Calculator> {
        val races = parseRaces()
        val classes = parseRPGClasses()
        return@single AlkonCalculator(races!!, classes!!)
    }

    factory { (name: String, race: String, rpgClass: String) ->
        Hero(
            name = name,
            race = race,
            rpgClass = rpgClass
        )
    }

}

fun parseRaces(): Map<String, Race>? {
    val moshi = Moshi.Builder().build()
    val mapType = Types.newParameterizedType(Map::class.java, String::class.java,Race::class.java)
    val adapter: JsonAdapter<Map<String,Race>> = moshi.adapter(mapType)
    return adapter.fromJson(Constants.racesJson)
}

fun parseRPGClasses(): Map<String, RPGClass>? {
    val moshi = Moshi.Builder().build()
    val mapType = Types.newParameterizedType(Map::class.java, String::class.java,RPGClass::class.java)
    val adapter: JsonAdapter<Map<String,RPGClass>> = moshi.adapter(mapType)
    return adapter.fromJson(Constants.rpgClassesJson)
}
