package edu.admafk.union.union_app.controller

import edu.admafk.union.union_app.entity.ComparisonCorrida
import com.admafk.union.union_app.service.ComparisonCorridaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/comparison-corrida")
class ComparisonCorridaController(private val comparisonCorridaService: ComparisonCorridaService) {

    @GetMapping
    fun getAllComparisonCorridas(): ResponseEntity<List<edu.admafk.union.union_app.entity.ComparisonCorrida>> {
        val comparisonCorridas = comparisonCorridaService.findAllComparisonCorridas()
        return ResponseEntity.ok(comparisonCorridas)
    }

    @GetMapping("/{id}")
    fun getComparisonCorridaById(@PathVariable id: Long): ResponseEntity<edu.admafk.union.union_app.entity.ComparisonCorrida> {
        val comparisonCorrida = comparisonCorridaService.findComparisonCorridaById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(comparisonCorrida)
    }

    @GetMapping("/player/{playerId}")
    fun getComparisonCorridasByPlayerId(@PathVariable playerId: Long): ResponseEntity<List<edu.admafk.union.union_app.entity.ComparisonCorrida>> {
        val comparisonCorridas = comparisonCorridaService.findComparisonCorridasByPlayerId(playerId)
        return ResponseEntity.ok(comparisonCorridas)
    }

    @PostMapping
    fun createComparisonCorrida(@RequestBody comparisonCorrida: edu.admafk.union.union_app.entity.ComparisonCorrida): ResponseEntity<edu.admafk.union.union_app.entity.ComparisonCorrida> {
        val newComparisonCorrida = comparisonCorridaService.createComparisonCorrida(comparisonCorrida)
        return ResponseEntity.ok(newComparisonCorrida)
    }

    @PutMapping("/{id}")
    fun updateComparisonCorrida(@PathVariable id: Long, @RequestBody comparisonCorrida: edu.admafk.union.union_app.entity.ComparisonCorrida): ResponseEntity<edu.admafk.union.union_app.entity.ComparisonCorrida> {
        val updatedComparisonCorrida = comparisonCorridaService.updateComparisonCorrida(id, comparisonCorrida) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedComparisonCorrida)
    }

    @DeleteMapping("/{id}")
    fun deleteComparisonCorrida(@PathVariable id: Long): ResponseEntity<Void> {
        return if (comparisonCorridaService.deleteComparisonCorrida(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
