package edu.admafk.union.union_app.controller

import com.admafk.union.union_app.entity.SubstitutosHerois
import com.admafk.union.union_app.service.SubstitutosHeroisService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/substitutos-herois")
class SubstitutosHeroisController(private val substitutosHeroisService: SubstitutosHeroisService) {

    @GetMapping
    fun getAllSubstitutosHerois(): ResponseEntity<List<SubstitutosHerois>> {
        val substitutosHerois = substitutosHeroisService.findAllSubstitutosHerois()
        return ResponseEntity.ok(substitutosHerois)
    }

    @GetMapping("/{id}")
    fun getSubstitutoHeroiById(@PathVariable id: Long): ResponseEntity<SubstitutosHerois> {
        val substitutoHeroi = substitutosHeroisService.findSubstitutoHeroiById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(substitutoHeroi)
    }

    @PostMapping
    fun createSubstitutoHeroi(@RequestBody substitutoHeroi: SubstitutosHerois): ResponseEntity<SubstitutosHerois> {
        val newSubstitutoHeroi = substitutosHeroisService.createSubstitutoHeroi(substitutoHeroi)
        return ResponseEntity.ok(newSubstitutoHeroi)
    }

    @PutMapping("/{id}")
    fun updateSubstitutoHeroi(@PathVariable id: Long, @RequestBody substitutoHeroi: SubstitutosHerois): ResponseEntity<SubstitutosHerois> {
        val updatedSubstitutoHeroi = substitutosHeroisService.updateSubstitutoHeroi(id, substitutoHeroi) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedSubstitutoHeroi)
    }

    @DeleteMapping("/{id}")
    fun deleteSubstitutoHeroi(@PathVariable id: Long): ResponseEntity<Void> {
        return if (substitutosHeroisService.deleteSubstitutoHeroi(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
