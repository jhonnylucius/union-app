package edu.admafk.union.union_app.dto

import java.time.LocalDateTime

data class UserSettingsDTO(
    val id: Long?,
    val userId: Long,
    val settings: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
)
