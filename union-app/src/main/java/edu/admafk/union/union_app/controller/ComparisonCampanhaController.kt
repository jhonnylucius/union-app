package edu.admafk.union.union_app.controller

import edu.admafk.union.union_app.entity.ComparisonCampanha
import com.admafk.union.union_app.service.ComparisonCampanhaService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/comparison-campanha")
class ComparisonCampanhaController(private val comparisonCampanhaService: ComparisonCampanhaService) {

    @GetMapping
    fun getAllComparisonCampanhas(): ResponseEntity<List<edu.admafk.union.union_app.entity.ComparisonCampanha>> {
        val comparisonCampanhas = comparisonCampanhaService.findAllComparisonCampanhas()
        return ResponseEntity.ok(comparisonCampanhas)
    }

    @GetMapping("/{id}")
    fun getComparisonCampanhaById(@PathVariable id: Long): ResponseEntity<edu.admafk.union.union_app.entity.ComparisonCampanha> {
        val comparisonCampanha = comparisonCampanhaService.findComparisonCampanhaById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(comparisonCampanha)
    }

    @GetMapping("/player/{playerId}")
    fun getComparisonCampanhasByPlayerId(@PathVariable playerId: Long): ResponseEntity<List<edu.admafk.union.union_app.entity.ComparisonCampanha>> {
        val comparisonCampanhas = comparisonCampanhaService.findComparisonCampanhasByPlayerId(playerId)
        return ResponseEntity.ok(comparisonCampanhas)
    }

    @PostMapping
    fun createComparisonCampanha(@RequestBody comparisonCampanha: edu.admafk.union.union_app.entity.ComparisonCampanha): ResponseEntity<edu.admafk.union.union_app.entity.ComparisonCampanha> {
        val newComparisonCampanha = comparisonCampanhaService.createComparisonCampanha(comparisonCampanha)
        return ResponseEntity.ok(newComparisonCampanha)
    }

    @PutMapping("/{id}")
    fun updateComparisonCampanha(@PathVariable id: Long, @RequestBody comparisonCampanha: edu.admafk.union.union_app.entity.ComparisonCampanha): ResponseEntity<edu.admafk.union.union_app.entity.ComparisonCampanha> {
        val updatedComparisonCampanha = comparisonCampanhaService.updateComparisonCampanha(id, comparisonCampanha) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedComparisonCampanha)
    }

    @DeleteMapping("/{id}")
    fun deleteComparisonCampanha(@PathVariable id: Long): ResponseEntity<Void> {
        return if (comparisonCampanhaService.deleteComparisonCampanha(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
