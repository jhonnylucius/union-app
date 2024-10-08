package edu.admafk.union.union_app.controller

import edu.admafk.union.union_app.entity.ComparisonMinas
import com.admafk.union.union_app.service.ComparisonMinasService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/comparison-minas")
class ComparisonMinasController(private val comparisonMinasService: ComparisonMinasService) {

    @GetMapping
    fun getAllComparisonMinas(): ResponseEntity<List<edu.admafk.union.union_app.entity.ComparisonMinas>> {
        val comparisonMinas = comparisonMinasService.findAllComparisonMinas()
        return ResponseEntity.ok(comparisonMinas)
    }

    @GetMapping("/{id}")
    fun getComparisonMinasById(@PathVariable id: Long): ResponseEntity<edu.admafk.union.union_app.entity.ComparisonMinas> {
        val comparisonMinas = comparisonMinasService.findComparisonMinasById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(comparisonMinas)
    }

    @GetMapping("/player/{playerId}")
    fun getComparisonMinasByPlayerId(@PathVariable playerId: Long): ResponseEntity<List<edu.admafk.union.union_app.entity.ComparisonMinas>> {
        val comparisonMinas = comparisonMinasService.findComparisonMinasByPlayerId(playerId)
        return ResponseEntity.ok(comparisonMinas)
    }

    @PostMapping
    fun createComparisonMinas(@RequestBody comparisonMinas: edu.admafk.union.union_app.entity.ComparisonMinas): ResponseEntity<edu.admafk.union.union_app.entity.ComparisonMinas> {
        val newComparisonMinas = comparisonMinasService.createComparisonMinas(comparisonMinas)
        return ResponseEntity.ok(newComparisonMinas)
    }

    @PutMapping("/{id}")
    fun updateComparisonMinas(@PathVariable id: Long, @RequestBody comparisonMinas: edu.admafk.union.union_app.entity.ComparisonMinas): ResponseEntity<edu.admafk.union.union_app.entity.ComparisonMinas> {
        val updatedComparisonMinas = comparisonMinasService.updateComparisonMinas(id, comparisonMinas) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedComparisonMinas)
    }

    @DeleteMapping("/{id}")
    fun deleteComparisonMinas(@PathVariable id: Long): ResponseEntity<Void> {
        return if (comparisonMinasService.deleteComparisonMinas(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
