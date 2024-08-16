package com.admafk.union.union_app.controller

import com.admafk.union.union_app.entity.ComparisonCamposDeCaca
import com.admafk.union.union_app.service.ComparisonCamposDeCacaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/comparison-campos-de-caca")
class ComparisonCamposDeCacaController(private val comparisonCamposDeCacaService: ComparisonCamposDeCacaService) {

    @GetMapping
    fun getAllComparisonCamposDeCaca(): ResponseEntity<List<ComparisonCamposDeCaca>> {
        val comparisonCamposDeCaca = comparisonCamposDeCacaService.findAllComparisonCamposDeCaca()
        return ResponseEntity.ok(comparisonCamposDeCaca)
    }

    @GetMapping("/{id}")
    fun getComparisonCamposDeCacaById(@PathVariable id: Long): ResponseEntity<ComparisonCamposDeCaca> {
        val comparisonCamposDeCaca = comparisonCamposDeCacaService.findComparisonCamposDeCacaById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(comparisonCamposDeCaca)
    }

    @GetMapping("/player/{playerId}")
    fun getComparisonCamposDeCacaByPlayerId(@PathVariable playerId: Long): ResponseEntity<List<ComparisonCamposDeCaca>> {
        val comparisonCamposDeCaca = comparisonCamposDeCacaService.findComparisonCamposDeCacaByPlayerId(playerId)
        return ResponseEntity.ok(comparisonCamposDeCaca)
    }

    @PostMapping
    fun createComparisonCamposDeCaca(@RequestBody comparisonCamposDeCaca: ComparisonCamposDeCaca): ResponseEntity<ComparisonCamposDeCaca> {
        val newComparisonCamposDeCaca = comparisonCamposDeCacaService.createComparisonCamposDeCaca(comparisonCamposDeCaca)
        return ResponseEntity.ok(newComparisonCamposDeCaca)
    }

    @PutMapping("/{id}")
    fun updateComparisonCamposDeCaca(@PathVariable id: Long, @RequestBody comparisonCamposDeCaca: ComparisonCamposDeCaca): ResponseEntity<ComparisonCamposDeCaca> {
        val updatedComparisonCamposDeCaca = comparisonCamposDeCacaService.updateComparisonCamposDeCaca(id, comparisonCamposDeCaca) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedComparisonCamposDeCaca)
    }

    @DeleteMapping("/{id}")
    fun deleteComparisonCamposDeCaca(@PathVariable id: Long): ResponseEntity<Void> {
        return if (comparisonCamposDeCacaService.deleteComparisonCamposDeCaca(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
