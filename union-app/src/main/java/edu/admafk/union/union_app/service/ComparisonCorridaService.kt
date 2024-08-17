package com.admafk.union.union_app.service

import com.admafk.union.union_app.entity.ComparisonCorrida
import com.admafk.union.union_app.repository.ComparisonCorridaRepository
import org.springframework.stereotype.Service

@Service
class ComparisonCorridaService(private val comparisonCorridaRepository: ComparisonCorridaRepository) {

    fun findAllComparisonCorridas(): List<ComparisonCorrida> = comparisonCorridaRepository.findAll()

    fun findComparisonCorridaById(id: Long): ComparisonCorrida? = comparisonCorridaRepository.findById(id).orElse(null)

    fun findComparisonCorridasByPlayerId(playerId: Long): List<ComparisonCorrida> = comparisonCorridaRepository.findByPlayerId(playerId)

    fun createComparisonCorrida(comparisonCorrida: ComparisonCorrida): ComparisonCorrida = comparisonCorridaRepository.save(comparisonCorrida)

    fun updateComparisonCorrida(id: Long, updatedComparisonCorrida: ComparisonCorrida): ComparisonCorrida? {
        val existingComparisonCorrida = comparisonCorridaRepository.findById(id).orElse(null) ?: return null
        val updatedComparisonCorridaEntity = existingComparisonCorrida.copy(
            hero = updatedComparisonCorrida.hero,
            numeroDaComp = updatedComparisonCorrida.numeroDaComp,
            posicaoNaComp = updatedComparisonCorrida.posicaoNaComp,
            instrucoes = updatedComparisonCorrida.instrucoes,
            pet = updatedComparisonCorrida.pet
        )
        return comparisonCorridaRepository.save(updatedComparisonCorridaEntity)
    }

    fun deleteComparisonCorrida(id: Long): Boolean {
        return if (comparisonCorridaRepository.existsById(id)) {
            comparisonCorridaRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
