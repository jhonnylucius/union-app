package edu.admafk.union.union_app.repository

import edu.admafk.union.union_app.entity.ComparisonReinoAmaldicoado
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComparisonReinoAmaldicoadoRepository : JpaRepository<edu.admafk.union.union_app.entity.ComparisonReinoAmaldicoado, Long> {
    fun findByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.ComparisonReinoAmaldicoado>
}
