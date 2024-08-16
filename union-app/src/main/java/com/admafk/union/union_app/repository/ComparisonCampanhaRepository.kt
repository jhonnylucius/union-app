package com.admafk.union.union_app.repository

import com.admafk.union.union_app.entity.ComparisonCampanha
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComparisonCampanhaRepository : JpaRepository<ComparisonCampanha, Long> {
    fun findByPlayerId(playerId: Long): List<ComparisonCampanha>
}
