package com.admafk.union.union_app.repository

import com.admafk.union.union_app.entity.ComparisonHistory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComparisonHistoryRepository : JpaRepository<ComparisonHistory, Long> {
    fun findByPlayerId(playerId: Long): List<ComparisonHistory>
}
