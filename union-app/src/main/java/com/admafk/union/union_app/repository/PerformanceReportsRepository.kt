package com.admafk.union.union_app.repository

import com.admafk.union.union_app.entity.PerformanceReports
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PerformanceReportsRepository : JpaRepository<PerformanceReports, Long> {
    fun findByPlayerId(playerId: Long): List<PerformanceReports>
}
