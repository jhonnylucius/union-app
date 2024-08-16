package com.admafk.union.union_app.repository

import com.admafk.union.union_app.entity.ComparisonCamposDeCaca
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComparisonCamposDeCacaRepository : JpaRepository<ComparisonCamposDeCaca, Long> {
    fun findByPlayerId(playerId: Long): List<ComparisonCamposDeCaca>
}
