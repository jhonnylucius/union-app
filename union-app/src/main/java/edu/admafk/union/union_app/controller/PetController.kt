package edu.admafk.union.union_app.controller

import edu.admafk.union.union_app.entity.Pet
import com.admafk.union.union_app.service.PetService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/pets")
class PetController(private val petService: PetService) {

    @GetMapping
    fun getAllPets(): ResponseEntity<List<edu.admafk.union.union_app.entity.Pet>> {
        val pets = petService.findAllPets()
        return ResponseEntity.ok(pets)
    }

    @GetMapping("/{id}")
    fun getPetById(@PathVariable id: Long): ResponseEntity<edu.admafk.union.union_app.entity.Pet> {
        val pet = petService.findPetById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(pet)
    }

    @PostMapping
    fun createPet(@RequestBody pet: edu.admafk.union.union_app.entity.Pet): ResponseEntity<edu.admafk.union.union_app.entity.Pet> {
        val newPet = petService.createPet(pet)
        return ResponseEntity.ok(newPet)
    }

    @PutMapping("/{id}")
    fun updatePet(@PathVariable id: Long, @RequestBody pet: edu.admafk.union.union_app.entity.Pet): ResponseEntity<edu.admafk.union.union_app.entity.Pet> {
        val updatedPet = petService.updatePet(id, pet) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedPet)
    }

    @DeleteMapping("/{id}")
    fun deletePet(@PathVariable id: Long): ResponseEntity<Void> {
        return if (petService.deletePet(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
