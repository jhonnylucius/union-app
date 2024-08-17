package com.admafk.union.union_app.dto

import java.time.LocalDateTime

data class ComparisonHistoryDTO(
    val id: Long?,
    val playerId: Long,
    val comparisonType: String,
    val comparisonResult: String,
    val createdAt: LocalDateTime
)
