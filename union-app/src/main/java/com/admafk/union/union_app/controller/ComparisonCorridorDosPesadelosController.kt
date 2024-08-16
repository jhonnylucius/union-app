package com.admafk.union.union_app.controller

import com.admafk.union.union_app.entity.ComparisonCorridorDosPesadelos
import com.admafk.union.union_app.service.ComparisonCorridorDosPesadelosService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/comparison-corridor-dos-pesadelos")
class ComparisonCorridorDosPesadelosController(private val comparisonCorridorDosPesadelosService: ComparisonCorridorDosPesadelosService) {

    @GetMapping
    fun getAllComparisonCorridorDosPesadelos(): ResponseEntity<List<ComparisonCorridorDosPesadelos>> {
        val comparisonCorridorDosPesadelos = comparisonCorridorDosPesadelosService.findAllComparisonCorridorDosPesadelos()
        return ResponseEntity.ok(comparisonCorridorDosPesadelos)
    }

    @GetMapping("/{id}")
    fun getComparisonCorridorDosPesadelosById(@PathVariable id: Long): ResponseEntity<ComparisonCorridorDosPesadelos> {
        val comparisonCorridorDosPesadelos = comparisonCorridorDosPesadelosService.findComparisonCorridorDosPesadelosById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(comparisonCorridorDosPesadelos)
    }

    @GetMapping("/player/{playerId}")
    fun getComparisonCorridorDosPesadelosByPlayerId(@PathVariable playerId: Long): ResponseEntity<List<ComparisonCorridorDosPesadelos>> {
        val comparisonCorridorDosPesadelos = comparisonCorridorDosPesadelosService.findComparisonCorridorDosPesadelosByPlayerId(playerId)
        return ResponseEntity.ok(comparisonCorridorDosPesadelos)
    }

    @PostMapping
    fun createComparisonCorridorDosPesadelos(@RequestBody comparisonCorridorDosPesadelos: ComparisonCorridorDosPesadelos): ResponseEntity<ComparisonCorridorDosPesadelos> {
        val newComparisonCorridorDosPesadelos = comparisonCorridorDosPesadelosService.createComparisonCorridorDosPesadelos(comparisonCorridorDosPesadelos)
        return ResponseEntity.ok(newComparisonCorridorDosPesadelos)
    }

    @PutMapping("/{id}")
    fun updateComparisonCorridorDosPesadelos(@PathVariable id: Long, @RequestBody comparisonCorridorDosPesadelos: ComparisonCorridorDosPesadelos): ResponseEntity<ComparisonCorridorDosPesadelos> {
        val updatedComparisonCorridorDosPesadelos = comparisonCorridorDosPesadelosService.updateComparisonCorridorDosPesadelos(id, comparisonCorridorDosPesadelos) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedComparisonCorridorDosPesadelos)
    }

    @DeleteMapping("/{id}")
    fun deleteComparisonCorridorDosPesadelos(@PathVariable id: Long): ResponseEntity<Void> {
        return if (comparisonCorridorDosPesadelosService.deleteComparisonCorridorDosPesadelos(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}

