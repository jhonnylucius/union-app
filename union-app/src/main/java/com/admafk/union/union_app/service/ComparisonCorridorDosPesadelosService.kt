package com.admafk.union.union_app.service

import com.admafk.union.union_app.entity.ComparisonCorridorDosPesadelos
import com.admafk.union.union_app.repository.ComparisonCorridorDosPesadelosRepository
import org.springframework.stereotype.Service

@Service
class ComparisonCorridorDosPesadelosService(private val comparisonCorridorDosPesadelosRepository: ComparisonCorridorDosPesadelosRepository) {

    fun findAllComparisonCorridorDosPesadelos(): List<ComparisonCorridorDosPesadelos> = comparisonCorridorDosPesadelosRepository.findAll()

    fun findComparisonCorridorDosPesadelosById(id: Long): ComparisonCorridorDosPesadelos? = comparisonCorridorDosPesadelosRepository.findById(id).orElse(null)

    fun findComparisonCorridorDosPesadelosByPlayerId(playerId: Long): List<ComparisonCorridorDosPesadelos> = comparisonCorridorDosPesadelosRepository.findByPlayerId(playerId)

    fun createComparisonCorridorDosPesadelos(comparisonCorridorDosPesadelos: ComparisonCorridorDosPesadelos): ComparisonCorridorDosPesadelos = comparisonCorridorDosPesadelosRepository.save(comparisonCorridorDosPesadelos)

    fun updateComparisonCorridorDosPesadelos(id: Long, updatedComparisonCorridorDosPesadelos: ComparisonCorridorDosPesadelos): ComparisonCorridorDosPesadelos? {
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
