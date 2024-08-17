package edu.admafk.union.union_app.dto

import java.time.LocalDateTime

data class ActivityLogDTO(
    val id: Long?,
    val userId: Long,
    val action: String,
    val timestamp: LocalDateTime
)
