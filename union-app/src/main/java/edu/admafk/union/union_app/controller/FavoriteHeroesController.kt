package edu.admafk.union.union_app.controller

import edu.admafk.union.union_app.entity.FavoriteHeroes
import com.admafk.union.union_app.service.FavoriteHeroesService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/favorite-heroes")
class FavoriteHeroesController(private val favoriteHeroesService: FavoriteHeroesService) {

    @GetMapping
    fun getAllFavoriteHeroes(): ResponseEntity<List<edu.admafk.union.union_app.entity.FavoriteHeroes>> {
        val favoriteHeroes = favoriteHeroesService.findAllFavoriteHeroes()
        return ResponseEntity.ok(favoriteHeroes)
    }

    @GetMapping("/{id}")
    fun getFavoriteHeroById(@PathVariable id: Long): ResponseEntity<edu.admafk.union.union_app.entity.FavoriteHeroes> {
        val favoriteHero = favoriteHeroesService.findFavoriteHeroById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(favoriteHero)
    }

    @GetMapping("/player/{playerId}")
    fun getFavoriteHeroesByPlayerId(@PathVariable playerId: Long): ResponseEntity<List<edu.admafk.union.union_app.entity.FavoriteHeroes>> {
        val favoriteHeroes = favoriteHeroesService.findFavoriteHeroesByPlayerId(playerId)
        return ResponseEntity.ok(favoriteHeroes)
    }

    @PostMapping
    fun createFavoriteHero(@RequestBody favoriteHero: edu.admafk.union.union_app.entity.FavoriteHeroes): ResponseEntity<edu.admafk.union.union_app.entity.FavoriteHeroes> {
        val newFavoriteHero = favoriteHeroesService.createFavoriteHero(favoriteHero)
        return ResponseEntity.ok(newFavoriteHero)
    }

    @PutMapping("/{id}")
    fun updateFavoriteHero(@PathVariable id: Long, @RequestBody favoriteHero: edu.admafk.union.union_app.entity.FavoriteHeroes): ResponseEntity<edu.admafk.union.union_app.entity.FavoriteHeroes> {
        val updatedFavoriteHero = favoriteHeroesService.updateFavoriteHero(id, favoriteHero) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedFavoriteHero)
    }

    @DeleteMapping("/{id}")
    fun deleteFavoriteHero(@PathVariable id: Long): ResponseEntity<Void> {
        return if (favoriteHeroesService.deleteFavoriteHero(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
