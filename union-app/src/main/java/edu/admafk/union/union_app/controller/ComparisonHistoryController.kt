package edu.admafk.union.union_app.controller

import edu.admafk.union.union_app.entity.ComparisonHistory
import com.admafk.union.union_app.service.ComparisonHistoryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/comparison-history")
class ComparisonHistoryController(private val comparisonHistoryService: ComparisonHistoryService) {

    @GetMapping
    fun getAllComparisonHistories(): ResponseEntity<List<edu.admafk.union.union_app.entity.ComparisonHistory>> {
        val comparisonHistories = comparisonHistoryService.findAllComparisonHistories()
        return ResponseEntity.ok(comparisonHistories)
    }

    @GetMapping("/{id}")
    fun getComparisonHistoryById(@PathVariable id: Long): ResponseEntity<edu.admafk.union.union_app.entity.ComparisonHistory> {
        val comparisonHistory = comparisonHistoryService.findComparisonHistoryById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(comparisonHistory)
    }

    @GetMapping("/player/{playerId}")
    fun getComparisonHistoriesByPlayerId(@PathVariable playerId: Long): ResponseEntity<List<edu.admafk.union.union_app.entity.ComparisonHistory>> {
        val comparisonHistories = comparisonHistoryService.findComparisonHistoriesByPlayerId(playerId)
        return ResponseEntity.ok(comparisonHistories)
    }

    @PostMapping
    fun createComparisonHistory(@RequestBody comparisonHistory: edu.admafk.union.union_app.entity.ComparisonHistory): ResponseEntity<edu.admafk.union.union_app.entity.ComparisonHistory> {
        val newComparisonHistory = comparisonHistoryService.createComparisonHistory(comparisonHistory)
        return ResponseEntity.ok(newComparisonHistory)
    }

    @PutMapping("/{id}")
    fun updateComparisonHistory(@PathVariable id: Long, @RequestBody comparisonHistory: edu.admafk.union.union_app.entity.ComparisonHistory): ResponseEntity<edu.admafk.union.union_app.entity.ComparisonHistory> {
        val updatedComparisonHistory = comparisonHistoryService.updateComparisonHistory(id, comparisonHistory) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedComparisonHistory)
    }

    @DeleteMapping("/{id}")
    fun deleteComparisonHistory(@PathVariable id: Long): ResponseEntity<Void> {
        return if (comparisonHistoryService.deleteComparisonHistory(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
