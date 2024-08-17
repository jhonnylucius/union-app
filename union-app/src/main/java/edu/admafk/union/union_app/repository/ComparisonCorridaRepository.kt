package edu.admafk.union.union_app.repository

import edu.admafk.union.union_app.entity.ComparisonCorrida
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComparisonCorridaRepository : JpaRepository<edu.admafk.union.union_app.entity.ComparisonCorrida, Long> {
    fun findByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.ComparisonCorrida>
}
