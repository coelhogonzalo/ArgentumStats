package com.coelhogonzalo.argentumstats.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class RPGClass(
    val name: String,
    @Json(name = "health_increases") val healthIncreases: List<Int>,
    @Json(name = "magic_power") val magicPower: Float
) {

    override fun toString(): String {
        return "[$name ,$healthIncreases, $magicPower]"
    }

    override fun equals(other: Any?) =
        (other is RPGClass) && name == other.name && (healthIncreases == other.healthIncreases) && magicPower == other.magicPower

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + healthIncreases.hashCode()
        result = 31 * result + magicPower.hashCode()
        return result
    }
}