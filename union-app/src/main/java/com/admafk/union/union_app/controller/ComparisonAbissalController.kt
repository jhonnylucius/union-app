package com.admafk.union.union_app.controller

import com.admafk.union.union_app.entity.ComparisonAbissal
import com.admafk.union.union_app.service.ComparisonAbissalService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/comparison-abissal")
class ComparisonAbissalController(private val comparisonAbissalService: ComparisonAbissalService) {

    @GetMapping
    fun getAllComparisonAbissals(): ResponseEntity<List<ComparisonAbissal>> {
        val comparisonAbissals = comparisonAbissalService.findAllComparisonAbissals()
        return ResponseEntity.ok(comparisonAbissals)
    }

    @GetMapping("/{id}")
    fun getComparisonAbissalById(@PathVariable id: Long): ResponseEntity<ComparisonAbissal> {
        val comparisonAbissal = comparisonAbissalService.findComparisonAbissalById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(comparisonAbissal)
    }

    @GetMapping("/player/{playerId}")
    fun getComparisonAbissalsByPlayerId(@PathVariable playerId: Long): ResponseEntity<List<ComparisonAbissal>> {
        val comparisonAbissals = comparisonAbissalService.findComparisonAbissalsByPlayerId(playerId)
        return ResponseEntity.ok(comparisonAbissals)
    }

    @PostMapping
    fun createComparisonAbissal(@RequestBody comparisonAbissal: ComparisonAbissal): ResponseEntity<ComparisonAbissal> {
        val newComparisonAbissal = comparisonAbissalService.createComparisonAbissal(comparisonAbissal)
        return ResponseEntity.ok(newComparisonAbissal)
    }

    @PutMapping("/{id}")
    fun updateComparisonAbissal(@PathVariable id: Long, @RequestBody comparisonAbissal: ComparisonAbissal): ResponseEntity<ComparisonAbissal> {
        val updatedComparisonAbissal = comparisonAbissalService.updateComparisonAbissal(id, comparisonAbissal) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedComparisonAbissal)
    }

    @DeleteMapping("/{id}")
    fun deleteComparisonAbissal(@PathVariable id: Long): ResponseEntity<Void> {
        return if (comparisonAbissalService.deleteComparisonAbissal(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
