package com.admafk.union.union_app.repository

import com.admafk.union.union_app.entity.FavoriteHeroes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FavoriteHeroesRepository : JpaRepository<FavoriteHeroes, Long> {
    fun findByPlayerId(playerId: Long): List<FavoriteHeroes>
}
