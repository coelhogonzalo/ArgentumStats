package com.coelhogonzalo.argentumstats.model

interface Calculator {
    fun getAvgHealth(hero:Hero,level:Int):Float
    fun getMana(hero:Hero,level:Int):Int
}