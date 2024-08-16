package com.admafk.union.union_app.dto

import java.time.LocalDateTime

data class PerformanceReportsDTO(
    val id: Long?,
    val playerId: Long,
    val reportData: String,
    val generatedAt: LocalDateTime
)
