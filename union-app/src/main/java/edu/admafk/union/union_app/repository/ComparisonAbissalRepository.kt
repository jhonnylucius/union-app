package edu.admafk.union.union_app.repository

import edu.admafk.union.union_app.entity.ComparisonAbissal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComparisonAbissalRepository : JpaRepository<edu.admafk.union.union_app.entity.ComparisonAbissal, Long> {
    fun findByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.ComparisonAbissal>
}
