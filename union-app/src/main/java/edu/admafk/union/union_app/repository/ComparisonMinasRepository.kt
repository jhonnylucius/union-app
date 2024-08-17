package edu.admafk.union.union_app.repository

import edu.admafk.union.union_app.entity.ComparisonMinas
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComparisonMinasRepository : JpaRepository<edu.admafk.union.union_app.entity.ComparisonMinas, Long> {
    fun findByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.ComparisonMinas>
}
