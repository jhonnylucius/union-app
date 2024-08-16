package com.admafk.union.union_app.controller

import com.admafk.union.union_app.entity.Player
import com.admafk.union.union_app.service.PlayerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/players")
class PlayerController(private val playerService: PlayerService) {

    @GetMapping
    fun getAllPlayers(): ResponseEntity<List<Player>> {
        val players = playerService.findAllPlayers()
        return ResponseEntity.ok(players)
    }

    @GetMapping("/{id}")
    fun getPlayerById(@PathVariable id: Long): ResponseEntity<Player> {
        val player = playerService.findPlayerById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(player)
    }

    @GetMapping("/user/{userId}")
    fun getPlayersByUserId(@PathVariable userId: Long): ResponseEntity<List<Player>> {
        val players = playerService.findPlayersByUserId(userId)
        return ResponseEntity.ok(players)
    }

    @PostMapping
    fun createPlayer(@RequestBody player: Player): ResponseEntity<Player> {
        val newPlayer = playerService.createPlayer(player)
        return ResponseEntity.ok(newPlayer)
    }

    @PutMapping("/{id}")
    fun updatePlayer(@PathVariable id: Long, @RequestBody player: Player): ResponseEntity<Player> {
        val updatedPlayer = playerService.updatePlayer(id, player) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedPlayer)
    }

    @DeleteMapping("/{id}")
    fun deletePlayer(@PathVariable id: Long): ResponseEntity<Void> {
        return if (playerService.deletePlayer(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
