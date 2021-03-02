package com.coelhogonzalo.argentumstats.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Hero(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val race: String,
    val rpgClass: String
) {

    override fun toString(): String {
        return "[$id ,$name, $race, $rpgClass]"
    }
}
