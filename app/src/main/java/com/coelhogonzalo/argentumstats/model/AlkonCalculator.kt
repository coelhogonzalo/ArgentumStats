package com.coelhogonzalo.argentumstats.model

class AlkonCalculator(val races: Map<String, Race>, val classes: Map<String, RPGClass>) :
    Calculator {

    override fun getAvgHealth(hero: Hero, level: Int):Float {
        val race = races[hero.race]
        val rpgClass = classes[hero.rpgClass]
        var avgHealthIncrease = 0f
        for (possibleIncrease: Int in rpgClass?.healthIncreases!!) {
            avgHealthIncrease += possibleIncrease
        }
        avgHealthIncrease /= rpgClass.healthIncreases.size
        return race?.initialHealth!! + avgHealthIncrease * (level-1)
    }


    override fun getMana(hero: Hero, level: Int):Int {
        TODO("Not yet implemented")
        //TODO REVISAR LOS VALORES DE MAGICPOWER E INTELIGENCIA EN CONSTANTS
    }

}
