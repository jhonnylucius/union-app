package edu.admafk.union.union_app.repository

import edu.admafk.union.union_app.entity.ComparisonCorridorDosPesadelos
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComparisonCorridorDosPesadelosRepository : JpaRepository<edu.admafk.union.union_app.entity.ComparisonCorridorDosPesadelos, Long> {
    fun findByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.ComparisonCorridorDosPesadelos>
}
