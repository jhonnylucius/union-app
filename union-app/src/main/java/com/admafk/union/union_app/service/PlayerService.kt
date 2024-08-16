package com.admafk.union.union_app.service

import com.admafk.union.union_app.entity.Player
import com.admafk.union.union_app.repository.PlayerRepository
import org.springframework.stereotype.Service

@Service
class PlayerService(private val playerRepository: PlayerRepository) {

    fun findAllPlayers(): List<Player> = playerRepository.findAll()

    fun findPlayerById(id: Long): Player? = playerRepository.findById(id).orElse(null)

    fun findPlayersByUserId(userId: Long): List<Player> = playerRepository.findByUserId(userId)

    fun createPlayer(player: Player): Player = playerRepository.save(player)

    fun updatePlayer(id: Long, updatedPlayer: Player): Player? {
        val existingPlayer = playerRepository.findById(id).orElse(null) ?: return null
        val updatedPlayerEntity = existingPlayer.copy(
            nome = updatedPlayer.nome
        )
        return playerRepository.save(updatedPlayerEntity)
    }

    fun deletePlayer(id: Long): Boolean {
        return if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
