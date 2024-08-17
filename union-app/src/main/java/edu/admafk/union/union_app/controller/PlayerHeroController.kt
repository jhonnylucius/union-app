package edu.admafk.union.union_app.controller

import com.admafk.union.union_app.entity.PlayerHero
import com.admafk.union.union_app.service.PlayerHeroService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/player-heroes")
class PlayerHeroController(private val playerHeroService: PlayerHeroService) {

    @GetMapping
    fun getAllPlayerHeroes(): ResponseEntity<List<PlayerHero>> {
        val playerHeroes = playerHeroService.findAllPlayerHeroes()
        return ResponseEntity.ok(playerHeroes)
    }

    @GetMapping("/{id}")
    fun getPlayerHeroById(@PathVariable id: Long): ResponseEntity<PlayerHero> {
        val playerHero = playerHeroService.findPlayerHeroById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(playerHero)
    }

    @GetMapping("/player/{playerId}")
    fun getPlayerHeroesByPlayerId(@PathVariable playerId: Long): ResponseEntity<List<PlayerHero>> {
        val playerHeroes = playerHeroService.findPlayerHeroesByPlayerId(playerId)
        return ResponseEntity.ok(playerHeroes)
    }

    @PostMapping
    fun createPlayerHero(@RequestBody playerHero: PlayerHero): ResponseEntity<PlayerHero> {
        val newPlayerHero = playerHeroService.createPlayerHero(playerHero)
        return ResponseEntity.ok(newPlayerHero)
    }

    @PutMapping("/{id}")
    fun updatePlayerHero(@PathVariable id: Long, @RequestBody playerHero: PlayerHero): ResponseEntity<PlayerHero> {
        val updatedPlayerHero = playerHeroService.updatePlayerHero(id, playerHero) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedPlayerHero)
    }

    @DeleteMapping("/{id}")
    fun deletePlayerHero(@PathVariable id: Long): ResponseEntity<Void> {
        return if (playerHeroService.deletePlayerHero(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
