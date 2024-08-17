package edu.admafk.union.union_app.repository

import edu.admafk.union.union_app.entity.ComparisonCampanha
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComparisonCampanhaRepository : JpaRepository<edu.admafk.union.union_app.entity.ComparisonCampanha, Long> {
    fun findByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.ComparisonCampanha>
}
