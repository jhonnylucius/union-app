package edu.admafk.union.union_app.repository

import edu.admafk.union.union_app.entity.ComparisonCamposDeCaca
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComparisonCamposDeCacaRepository : JpaRepository<edu.admafk.union.union_app.entity.ComparisonCamposDeCaca, Long> {
    fun findByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.ComparisonCamposDeCaca>
}
