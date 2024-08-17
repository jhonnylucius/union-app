package edu.admafk.union.union_app.repository

import edu.admafk.union.union_app.entity.FavoriteHeroes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FavoriteHeroesRepository : JpaRepository<edu.admafk.union.union_app.entity.FavoriteHeroes, Long> {
    fun findByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.FavoriteHeroes>
}
