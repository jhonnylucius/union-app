package com.admafk.union.union_app.service

import com.admafk.union.union_app.entity.ComparisonAbissal
import com.admafk.union.union_app.repository.ComparisonAbissalRepository
import org.springframework.stereotype.Service

@Service
class ComparisonAbissalService(private val comparisonAbissalRepository: ComparisonAbissalRepository) {

    fun findAllComparisonAbissals(): List<ComparisonAbissal> = comparisonAbissalRepository.findAll()

    fun findComparisonAbissalById(id: Long): ComparisonAbissal? = comparisonAbissalRepository.findById(id).orElse(null)

    fun findComparisonAbissalsByPlayerId(playerId: Long): List<ComparisonAbissal> = comparisonAbissalRepository.findByPlayerId(playerId)

    fun createComparisonAbissal(comparisonAbissal: ComparisonAbissal): ComparisonAbissal = comparisonAbissalRepository.save(comparisonAbissal)

    fun updateComparisonAbissal(id: Long, updatedComparisonAbissal: ComparisonAbissal): ComparisonAbissal? {
        val existingComparisonAbissal = comparisonAbissalRepository.findById(id).orElse(null) ?: return null
        val updatedComparisonAbissalEntity = existingComparisonAbissal.copy(
            hero = updatedComparisonAbissal.hero,
            numeroDaComp = updatedComparisonAbissal.numeroDaComp,
            posicaoNaComp = updatedComparisonAbissal.posicaoNaComp,
            instrucoes = updatedComparisonAbissal.instrucoes,
            pet = updatedComparisonAbissal.pet
        )
        return comparisonAbissalRepository.save(updatedComparisonAbissalEntity)
    }

    fun deleteComparisonAbissal(id: Long): Boolean {
        return if (comparisonAbissalRepository.existsById(id)) {
            comparisonAbissalRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
