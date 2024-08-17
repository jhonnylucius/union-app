package edu.admafk.union.union_app.repository

import edu.admafk.union.union_app.entity.ComparisonHistory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComparisonHistoryRepository : JpaRepository<edu.admafk.union.union_app.entity.ComparisonHistory, Long> {
    fun findByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.ComparisonHistory>
}
