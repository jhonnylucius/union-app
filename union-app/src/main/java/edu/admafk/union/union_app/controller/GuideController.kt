package edu.admafk.union.union_app.controller

import edu.admafk.union.union_app.entity.Guide
import com.admafk.union.union_app.service.GuideService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/guides")
class GuideController(private val guideService: GuideService) {

    @GetMapping
    fun getAllGuides(): ResponseEntity<List<edu.admafk.union.union_app.entity.Guide>> {
        val guides = guideService.findAllGuides()
        return ResponseEntity.ok(guides)
    }

    @GetMapping("/{id}")
    fun getGuideById(@PathVariable id: Long): ResponseEntity<edu.admafk.union.union_app.entity.Guide> {
        val guide = guideService.findGuideById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(guide)
    }

    @GetMapping("/player/{playerId}")
    fun getGuidesByPlayerId(@PathVariable playerId: Long): ResponseEntity<List<edu.admafk.union.union_app.entity.Guide>> {
        val guides = guideService.findGuidesByPlayerId(playerId)
        return ResponseEntity.ok(guides)
    }

    @PostMapping
    fun createGuide(@RequestBody guide: edu.admafk.union.union_app.entity.Guide): ResponseEntity<edu.admafk.union.union_app.entity.Guide> {
        val newGuide = guideService.createGuide(guide)
        return ResponseEntity.ok(newGuide)
    }

    @PutMapping("/{id}")
    fun updateGuide(@PathVariable id: Long, @RequestBody guide: edu.admafk.union.union_app.entity.Guide): ResponseEntity<edu.admafk.union.union_app.entity.Guide> {
        val updatedGuide = guideService.updateGuide(id, guide) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedGuide)
    }

    @DeleteMapping("/{id}")
    fun deleteGuide(@PathVariable id: Long): ResponseEntity<Void> {
        return if (guideService.deleteGuide(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
