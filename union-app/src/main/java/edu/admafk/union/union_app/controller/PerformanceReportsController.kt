package edu.admafk.union.union_app.controller

import edu.admafk.union.union_app.entity.PerformanceReports
import com.admafk.union.union_app.service.PerformanceReportsService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/performance-reports")
class PerformanceReportsController(private val performanceReportsService: PerformanceReportsService) {

    @GetMapping
    fun getAllPerformanceReports(): ResponseEntity<List<edu.admafk.union.union_app.entity.PerformanceReports>> {
        val performanceReports = performanceReportsService.findAllPerformanceReports()
        return ResponseEntity.ok(performanceReports)
    }

    @GetMapping("/{id}")
    fun getPerformanceReportById(@PathVariable id: Long): ResponseEntity<edu.admafk.union.union_app.entity.PerformanceReports> {
        val performanceReport = performanceReportsService.findPerformanceReportById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(performanceReport)
    }

    @GetMapping("/player/{playerId}")
    fun getPerformanceReportsByPlayerId(@PathVariable playerId: Long): ResponseEntity<List<edu.admafk.union.union_app.entity.PerformanceReports>> {
        val performanceReports = performanceReportsService.findPerformanceReportsByPlayerId(playerId)
        return ResponseEntity.ok(performanceReports)
    }

    @PostMapping
    fun createPerformanceReport(@RequestBody performanceReport: edu.admafk.union.union_app.entity.PerformanceReports): ResponseEntity<edu.admafk.union.union_app.entity.PerformanceReports> {
        val newPerformanceReport = performanceReportsService.createPerformanceReport(performanceReport)
        return ResponseEntity.ok(newPerformanceReport)
    }

    @PutMapping("/{id}")
    fun updatePerformanceReport(@PathVariable id: Long, @RequestBody performanceReport: edu.admafk.union.union_app.entity.PerformanceReports): ResponseEntity<edu.admafk.union.union_app.entity.PerformanceReports> {
        val updatedPerformanceReport = performanceReportsService.updatePerformanceReport(id, performanceReport) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedPerformanceReport)
    }

    @DeleteMapping("/{id}")
    fun deletePerformanceReport(@PathVariable id: Long): ResponseEntity<Void> {
        return if (performanceReportsService.deletePerformanceReport(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
