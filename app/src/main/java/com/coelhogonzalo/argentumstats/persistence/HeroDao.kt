package com.coelhogonzalo.argentumstats.persistence

import androidx.room.*
import com.coelhogonzalo.argentumstats.model.Hero

@Dao
interface HeroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHero(hero: Hero)

    @Query("SELECT * FROM Hero WHERE id = :id_")
    fun getHero(id_: Long): Hero

    @Query("SELECT * FROM Hero")
    fun getAllHeroes(): List<Hero>

    @Delete
    fun delete(hero: Hero)

    @Query("DELETE FROM Hero")
    fun deleteAll()
}