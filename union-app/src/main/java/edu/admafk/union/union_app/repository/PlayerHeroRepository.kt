package com.admafk.union.union_app.repository

import com.admafk.union.union_app.entity.PlayerHero
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerHeroRepository : JpaRepository<PlayerHero, Long> {
    fun findByPlayerId(playerId: Long): List<PlayerHero>
}
