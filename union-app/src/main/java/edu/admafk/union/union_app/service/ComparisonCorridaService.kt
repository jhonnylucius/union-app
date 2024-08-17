package edu.admafk.union.union_app.service

import edu.admafk.union.union_app.entity.ComparisonCorrida
import edu.admafk.union.union_app.repository.ComparisonCorridaRepository
import org.springframework.stereotype.Service

@Service
class ComparisonCorridaService(private val comparisonCorridaRepository: edu.admafk.union.union_app.repository.ComparisonCorridaRepository) {

    fun findAllComparisonCorridas(): List<edu.admafk.union.union_app.entity.ComparisonCorrida> = comparisonCorridaRepository.findAll()

    fun findComparisonCorridaById(id: Long): edu.admafk.union.union_app.entity.ComparisonCorrida? = comparisonCorridaRepository.findById(id).orElse(null)

    fun findComparisonCorridasByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.ComparisonCorrida> = comparisonCorridaRepository.findByPlayerId(playerId)

    fun createComparisonCorrida(comparisonCorrida: edu.admafk.union.union_app.entity.ComparisonCorrida): edu.admafk.union.union_app.entity.ComparisonCorrida = comparisonCorridaRepository.save(comparisonCorrida)

    fun updateComparisonCorrida(id: Long, updatedComparisonCorrida: edu.admafk.union.union_app.entity.ComparisonCorrida): edu.admafk.union.union_app.entity.ComparisonCorrida? {
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
