package com.admafk.union.union_app.repository

import com.admafk.union.union_app.entity.ComparisonCorridorDosPesadelos
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ComparisonCorridorDosPesadelosRepository : JpaRepository<ComparisonCorridorDosPesadelos, Long> {
    fun findByPlayerId(playerId: Long): List<ComparisonCorridorDosPesadelos>
}
