package com.admafk.union.union_app.repository

import com.admafk.union.union_app.entity.ComparisonReinoAmaldicoado
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComparisonReinoAmaldicoadoRepository : JpaRepository<ComparisonReinoAmaldicoado, Long> {
    fun findByPlayerId(playerId: Long): List<ComparisonReinoAmaldicoado>
}
