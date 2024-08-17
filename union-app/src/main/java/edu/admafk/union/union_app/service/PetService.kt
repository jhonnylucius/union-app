package edu.admafk.union.union_app.service

import edu.admafk.union.union_app.entity.Pet
import com.admafk.union.union_app.repository.PetRepository
import org.springframework.stereotype.Service

@Service
class PetService(private val petRepository: PetRepository) {

    fun findAllPets(): List<edu.admafk.union.union_app.entity.Pet> = petRepository.findAll()

    fun findPetById(id: Long): edu.admafk.union.union_app.entity.Pet? = petRepository.findById(id).orElse(null)

    fun createPet(pet: edu.admafk.union.union_app.entity.Pet): edu.admafk.union.union_app.entity.Pet = petRepository.save(pet)

    fun updatePet(id: Long, updatedPet: edu.admafk.union.union_app.entity.Pet): edu.admafk.union.union_app.entity.Pet? {
        val existingPet = petRepository.findById(id).orElse(null) ?: return null
        val updatedPetEntity = existingPet.copy(
            nome = updatedPet.nome,
            urlPet = updatedPet.urlPet
        )
        return petRepository.save(updatedPetEntity)
    }

    fun deletePet(id: Long): Boolean {
        return if (petRepository.existsById(id)) {
            petRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
