package edu.admafk.union.union_app.dto

import java.time.LocalDateTime

data class FavoriteHeroesDTO(
    val id: Long?,
    val playerId: Long,
    val heroiId: Long,
    val addedAt: LocalDateTime
)
