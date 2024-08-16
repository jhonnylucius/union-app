package com.admafk.union.union_app.service

import com.admafk.union.union_app.entity.FavoriteHeroes
import com.admafk.union.union_app.repository.FavoriteHeroesRepository
import org.springframework.stereotype.Service

@Service
class FavoriteHeroesService(private val favoriteHeroesRepository: FavoriteHeroesRepository) {

    fun findAllFavoriteHeroes(): List<FavoriteHeroes> = favoriteHeroesRepository.findAll()

    fun findFavoriteHeroById(id: Long): FavoriteHeroes? = favoriteHeroesRepository.findById(id).orElse(null)

    fun findFavoriteHeroesByPlayerId(playerId: Long): List<FavoriteHeroes> = favoriteHeroesRepository.findByPlayerId(playerId)

    fun createFavoriteHero(favoriteHero: FavoriteHeroes): FavoriteHeroes = favoriteHeroesRepository.save(favoriteHero)

    fun updateFavoriteHero(id: Long, updatedFavoriteHero: FavoriteHeroes): FavoriteHeroes? {
        val existingFavoriteHero = favoriteHeroesRepository.findById(id).orElse(null) ?: return null
        val updatedFavoriteHeroEntity = existingFavoriteHero.copy(
            hero = updatedFavoriteHero.hero,
            addedAt = updatedFavoriteHero.addedAt
        )
        return favoriteHeroesRepository.save(updatedFavoriteHeroEntity)
    }

    fun deleteFavoriteHero(id: Long): Boolean {
        return if (favoriteHeroesRepository.existsById(id)) {
            favoriteHeroesRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
