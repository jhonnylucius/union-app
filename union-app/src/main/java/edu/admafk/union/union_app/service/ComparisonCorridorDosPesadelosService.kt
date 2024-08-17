package edu.admafk.union.union_app.service

import edu.admafk.union.union_app.entity.ComparisonCorridorDosPesadelos
import edu.admafk.union.union_app.repository.ComparisonCorridorDosPesadelosRepository
import org.springframework.stereotype.Service

@Service
class ComparisonCorridorDosPesadelosService(private val comparisonCorridorDosPesadelosRepository: edu.admafk.union.union_app.repository.ComparisonCorridorDosPesadelosRepository) {

    fun findAllComparisonCorridorDosPesadelos(): List<edu.admafk.union.union_app.entity.ComparisonCorridorDosPesadelos> = comparisonCorridorDosPesadelosRepository.findAll()

    fun findComparisonCorridorDosPesadelosById(id: Long): edu.admafk.union.union_app.entity.ComparisonCorridorDosPesadelos? = comparisonCorridorDosPesadelosRepository.findById(id).orElse(null)

    fun findComparisonCorridorDosPesadelosByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.ComparisonCorridorDosPesadelos> = comparisonCorridorDosPesadelosRepository.findByPlayerId(playerId)

    fun createComparisonCorridorDosPesadelos(comparisonCorridorDosPesadelos: edu.admafk.union.union_app.entity.ComparisonCorridorDosPesadelos): edu.admafk.union.union_app.entity.ComparisonCorridorDosPesadelos = comparisonCorridorDosPesadelosRepository.save(comparisonCorridorDosPesadelos)

    fun updateComparisonCorridorDosPesadelos(id: Long, updatedComparisonCorridorDosPesadelos: edu.admafk.union.union_app.entity.ComparisonCorridorDosPesadelos): edu.admafk.union.union_app.entity.ComparisonCorridorDosPesadelos? {
        val existingComparisonCorridorDosPesadelos = comparisonCorridorDosPesadelosRepository.findById(id).orElse(null) ?: return null
        val updatedComparisonCorridorDosPesadelosEntity = existingComparisonCorridorDosPesadelos.copy(
            hero = updatedComparisonCorridorDosPesadelos.hero,
            numeroDaComp = updatedComparisonCorridorDosPesadelos.numeroDaComp,
            posicaoNaComp = updatedComparisonCorridorDosPesadelos.posicaoNaComp,
            instrucoes = updatedComparisonCorridorDosPesadelos.instrucoes,
            pet = updatedComparisonCorridorDosPesadelos.pet
        )
        return comparisonCorridorDosPesadelosRepository.save(updatedComparisonCorridorDosPesadelosEntity)
    }

    fun deleteComparisonCorridorDosPesadelos(id: Long): Boolean {
        return if (comparisonCorridorDosPesadelosRepository.existsById(id)) {
            comparisonCorridorDosPesadelosRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
