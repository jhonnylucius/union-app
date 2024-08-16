package com.admafk.union.union_app.controller

import com.admafk.union.union_app.entity.Hero
import com.admafk.union.union_app.service.HeroService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/heroes")
class HeroController(private val heroService: HeroService) {

    @GetMapping
    fun getAllHeroes(): ResponseEntity<List<Hero>> {
        val heroes = heroService.findAllHeroes()
        return ResponseEntity.ok(heroes)
    }

    @GetMapping("/{id}")
    fun getHeroById(@PathVariable id: Long): ResponseEntity<Hero> {
        val hero = heroService.findHeroById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(hero)
    }

    @PostMapping
    fun createHero(@RequestBody hero: Hero): ResponseEntity<Hero> {
        val newHero = heroService.createHero(hero)
        return ResponseEntity.ok(newHero)
    }

    @PutMapping("/{id}")
    fun updateHero(@PathVariable id: Long, @RequestBody hero: Hero): ResponseEntity<Hero> {
        val updatedHero = heroService.updateHero(id, hero) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedHero)
    }

    @DeleteMapping("/{id}")
    fun deleteHero(@PathVariable id: Long): ResponseEntity<Void> {
        return if (heroService.deleteHero(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
