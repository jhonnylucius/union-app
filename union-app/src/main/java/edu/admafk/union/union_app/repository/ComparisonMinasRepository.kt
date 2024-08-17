package com.admafk.union.union_app.repository

import com.admafk.union.union_app.entity.ComparisonMinas
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComparisonMinasRepository : JpaRepository<ComparisonMinas, Long> {
    fun findByPlayerId(playerId: Long): List<ComparisonMinas>
}
