package com.admafk.union.union_app.service

import com.admafk.union.union_app.entity.PlayerHero
import com.admafk.union.union_app.repository.PlayerHeroRepository
import org.springframework.stereotype.Service

@Service
class PlayerHeroService(private val playerHeroRepository: PlayerHeroRepository) {

    fun findAllPlayerHeroes(): List<PlayerHero> = playerHeroRepository.findAll()

    fun findPlayerHeroById(id: Long): PlayerHero? = playerHeroRepository.findById(id).orElse(null)

    fun findPlayerHeroesByPlayerId(playerId: Long): List<PlayerHero> = playerHeroRepository.findByPlayerId(playerId)

    fun createPlayerHero(playerHero: PlayerHero): PlayerHero = playerHeroRepository.save(playerHero)

    fun updatePlayerHero(id: Long, updatedPlayerHero: PlayerHero): PlayerHero? {
        val existingPlayerHero = playerHeroRepository.findById(id).orElse(null) ?: return null
        val updatedPlayerHeroEntity = existingPlayerHero.copy(
            hero = updatedPlayerHero.hero
        )
        return playerHeroRepository.save(updatedPlayerHeroEntity)
    }

    fun deletePlayerHero(id: Long): Boolean {
        return if (playerHeroRepository.existsById(id)) {
            playerHeroRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
