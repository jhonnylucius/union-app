package com.admafk.union.union_app.service

import com.admafk.union.union_app.entity.PerformanceReports
import com.admafk.union.union_app.repository.PerformanceReportsRepository
import org.springframework.stereotype.Service

@Service
class PerformanceReportsService(private val performanceReportsRepository: PerformanceReportsRepository) {

    fun findAllPerformanceReports(): List<PerformanceReports> = performanceReportsRepository.findAll()

    fun findPerformanceReportById(id: Long): PerformanceReports? = performanceReportsRepository.findById(id).orElse(null)

    fun findPerformanceReportsByPlayerId(playerId: Long): List<PerformanceReports> = performanceReportsRepository.findByPlayerId(playerId)

    fun createPerformanceReport(performanceReport: PerformanceReports): PerformanceReports = performanceReportsRepository.save(performanceReport)

    fun updatePerformanceReport(id: Long, updatedPerformanceReport: PerformanceReports): PerformanceReports? {
        val existingPerformanceReport = performanceReportsRepository.findById(id).orElse(null) ?: return null
        val updatedPerformanceReportEntity = existingPerformanceReport.copy(
            reportData = updatedPerformanceReport.reportData,
            generatedAt = updatedPerformanceReport.generatedAt
        )
        return performanceReportsRepository.save(updatedPerformanceReportEntity)
    }

    fun deletePerformanceReport(id: Long): Boolean {
        return if (performanceReportsRepository.existsById(id)) {
            performanceReportsRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
