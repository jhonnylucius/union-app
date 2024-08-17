package com.admafk.union.union_app.repository

import com.admafk.union.union_app.entity.ComparisonAbissal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComparisonAbissalRepository : JpaRepository<ComparisonAbissal, Long> {
    fun findByPlayerId(playerId: Long): List<ComparisonAbissal>
}
