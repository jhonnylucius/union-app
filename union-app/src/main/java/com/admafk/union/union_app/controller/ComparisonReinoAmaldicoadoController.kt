package com.admafk.union.union_app.controller

import com.admafk.union.union_app.entity.ComparisonReinoAmaldicoado
import com.admafk.union.union_app.service.ComparisonReinoAmaldicoadoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/comparison-reino-amaldicoado")
class ComparisonReinoAmaldicoadoController(private val comparisonReinoAmaldicoadoService: ComparisonReinoAmaldicoadoService) {

    @GetMapping
    fun getAllComparisonReinoAmaldicoado(): ResponseEntity<List<ComparisonReinoAmaldicoado>> {
        val comparisonReinoAmaldicoado = comparisonReinoAmaldicoadoService.findAllComparisonReinoAmaldicoado()
        return ResponseEntity.ok(comparisonReinoAmaldicoado)
    }

    @GetMapping("/{id}")
    fun getComparisonReinoAmaldicoadoById(@PathVariable id: Long): ResponseEntity<ComparisonReinoAmaldicoado> {
        val comparisonReinoAmaldicoado = comparisonReinoAmaldicoadoService.findComparisonReinoAmaldicoadoById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(comparisonReinoAmaldicoado)
    }

    @GetMapping("/player/{playerId}")
    fun getComparisonReinoAmaldicoadoByPlayerId(@PathVariable playerId: Long): ResponseEntity<List<ComparisonReinoAmaldicoado>> {
        val comparisonReinoAmaldicoado = comparisonReinoAmaldicoadoService.findComparisonReinoAmaldicoadoByPlayerId(playerId)
        return ResponseEntity.ok(comparisonReinoAmaldicoado)
    }

    @PostMapping
    fun createComparisonReinoAmaldicoado(@RequestBody comparisonReinoAmaldicoado: ComparisonReinoAmaldicoado): ResponseEntity<ComparisonReinoAmaldicoado> {
        val newComparisonReinoAmaldicoado = comparisonReinoAmaldicoadoService.createComparisonReinoAmaldicoado(comparisonReinoAmaldicoado)
        return ResponseEntity.ok(newComparisonReinoAmaldicoado)
    }

    @PutMapping("/{id}")
    fun updateComparisonReinoAmaldicoado(@PathVariable id: Long, @RequestBody comparisonReinoAmaldicoado: ComparisonReinoAmaldicoado): ResponseEntity<ComparisonReinoAmaldicoado> {
        val updatedComparisonReinoAmaldicoado = comparisonReinoAmaldicoadoService.updateComparisonReinoAmaldicoado(id, comparisonReinoAmaldicoado) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedComparisonReinoAmaldicoado)
    }

    @DeleteMapping("/{id}")
    fun deleteComparisonReinoAmaldicoado(@PathVariable id: Long): ResponseEntity<Void> {
        return if (comparisonReinoAmaldicoadoService.deleteComparisonReinoAmaldicoado(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
