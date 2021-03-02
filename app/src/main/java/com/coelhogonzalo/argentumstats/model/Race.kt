package com.coelhogonzalo.argentumstats.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
class Race(
    val name: String,
    @Json(name = "initial_health")
    val initialHealth: Int,
    val intelligence: Int
) {

    override fun toString(): String {
        return "[$name ,$initialHealth, $intelligence]"
    }

    override fun equals(other: Any?) =
        (other is Race) && name == other.name && initialHealth == other.initialHealth && intelligence == other.intelligence

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + initialHealth
        result = 31 * result + intelligence
        return result
    }

}