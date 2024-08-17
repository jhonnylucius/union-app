package edu.admafk.union.union_app.service

import edu.admafk.union.union_app.entity.ComparisonCampanha
import edu.admafk.union.union_app.repository.ComparisonCampanhaRepository
import org.springframework.stereotype.Service

@Service
class ComparisonCampanhaService(private val comparisonCampanhaRepository: edu.admafk.union.union_app.repository.ComparisonCampanhaRepository) {

    fun findAllComparisonCampanhas(): List<edu.admafk.union.union_app.entity.ComparisonCampanha> = comparisonCampanhaRepository.findAll()

    fun findComparisonCampanhaById(id: Long): edu.admafk.union.union_app.entity.ComparisonCampanha? = comparisonCampanhaRepository.findById(id).orElse(null)

    fun findComparisonCampanhasByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.ComparisonCampanha> = comparisonCampanhaRepository.findByPlayerId(playerId)

    fun createComparisonCampanha(comparisonCampanha: edu.admafk.union.union_app.entity.ComparisonCampanha): edu.admafk.union.union_app.entity.ComparisonCampanha = comparisonCampanhaRepository.save(comparisonCampanha)

    fun updateComparisonCampanha(id: Long, updatedComparisonCampanha: edu.admafk.union.union_app.entity.ComparisonCampanha): edu.admafk.union.union_app.entity.ComparisonCampanha? {
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
