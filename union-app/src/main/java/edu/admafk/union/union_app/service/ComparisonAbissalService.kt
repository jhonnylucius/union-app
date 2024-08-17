package edu.admafk.union.union_app.service

import edu.admafk.union.union_app.entity.ComparisonAbissal
import edu.admafk.union.union_app.repository.ComparisonAbissalRepository
import org.springframework.stereotype.Service

@Service
class ComparisonAbissalService(private val comparisonAbissalRepository: edu.admafk.union.union_app.repository.ComparisonAbissalRepository) {

    fun findAllComparisonAbissals(): List<edu.admafk.union.union_app.entity.ComparisonAbissal> = comparisonAbissalRepository.findAll()

    fun findComparisonAbissalById(id: Long): edu.admafk.union.union_app.entity.ComparisonAbissal? = comparisonAbissalRepository.findById(id).orElse(null)

    fun findComparisonAbissalsByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.ComparisonAbissal> = comparisonAbissalRepository.findByPlayerId(playerId)

    fun createComparisonAbissal(comparisonAbissal: edu.admafk.union.union_app.entity.ComparisonAbissal): edu.admafk.union.union_app.entity.ComparisonAbissal = comparisonAbissalRepository.save(comparisonAbissal)

    fun updateComparisonAbissal(id: Long, updatedComparisonAbissal: edu.admafk.union.union_app.entity.ComparisonAbissal): edu.admafk.union.union_app.entity.ComparisonAbissal? {
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
