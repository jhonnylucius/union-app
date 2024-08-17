package com.admafk.union.union_app.service

import com.admafk.union.union_app.entity.ComparisonCampanha
import com.admafk.union.union_app.repository.ComparisonCampanhaRepository
import org.springframework.stereotype.Service

@Service
class ComparisonCampanhaService(private val comparisonCampanhaRepository: ComparisonCampanhaRepository) {

    fun findAllComparisonCampanhas(): List<ComparisonCampanha> = comparisonCampanhaRepository.findAll()

    fun findComparisonCampanhaById(id: Long): ComparisonCampanha? = comparisonCampanhaRepository.findById(id).orElse(null)

    fun findComparisonCampanhasByPlayerId(playerId: Long): List<ComparisonCampanha> = comparisonCampanhaRepository.findByPlayerId(playerId)

    fun createComparisonCampanha(comparisonCampanha: ComparisonCampanha): ComparisonCampanha = comparisonCampanhaRepository.save(comparisonCampanha)

    fun updateComparisonCampanha(id: Long, updatedComparisonCampanha: ComparisonCampanha): ComparisonCampanha? {
        val existingComparisonCampanha = comparisonCampanhaRepository.findById(id).orElse(null) ?: return null
        val updatedComparisonCampanhaEntity = existingComparisonCampanha.copy(
            hero = updatedComparisonCampanha.hero,
            numeroDaComp = updatedComparisonCampanha.numeroDaComp,
            posicaoNaComp = updatedComparisonCampanha.posicaoNaComp,
            instrucoes = updatedComparisonCampanha.instrucoes,
            pet = updatedComparisonCampanha.pet
        )
        return comparisonCampanhaRepository.save(updatedComparisonCampanhaEntity)
    }

    fun deleteComparisonCampanha(id: Long): Boolean {
        return if (comparisonCampanhaRepository.existsById(id)) {
            comparisonCampanhaRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
