package edu.admafk.union.union_app.repository

import edu.admafk.union.union_app.entity.PerformanceReports
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PerformanceReportsRepository : JpaRepository<edu.admafk.union.union_app.entity.PerformanceReports, Long> {
    fun findByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.PerformanceReports>
}
