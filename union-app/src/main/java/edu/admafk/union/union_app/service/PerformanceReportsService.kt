package edu.admafk.union.union_app.service

import edu.admafk.union.union_app.entity.PerformanceReports
import com.admafk.union.union_app.repository.PerformanceReportsRepository
import org.springframework.stereotype.Service

@Service
class PerformanceReportsService(private val performanceReportsRepository: PerformanceReportsRepository) {

    fun findAllPerformanceReports(): List<edu.admafk.union.union_app.entity.PerformanceReports> = performanceReportsRepository.findAll()

    fun findPerformanceReportById(id: Long): edu.admafk.union.union_app.entity.PerformanceReports? = performanceReportsRepository.findById(id).orElse(null)

    fun findPerformanceReportsByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.PerformanceReports> = performanceReportsRepository.findByPlayerId(playerId)

    fun createPerformanceReport(performanceReport: edu.admafk.union.union_app.entity.PerformanceReports): edu.admafk.union.union_app.entity.PerformanceReports = performanceReportsRepository.save(performanceReport)

    fun updatePerformanceReport(id: Long, updatedPerformanceReport: edu.admafk.union.union_app.entity.PerformanceReports): edu.admafk.union.union_app.entity.PerformanceReports? {
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
