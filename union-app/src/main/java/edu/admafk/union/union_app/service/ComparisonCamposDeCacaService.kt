package edu.admafk.union.union_app.service

import edu.admafk.union.union_app.entity.ComparisonCamposDeCaca
import edu.admafk.union.union_app.repository.ComparisonCamposDeCacaRepository
import org.springframework.stereotype.Service

@Service
class ComparisonCamposDeCacaService(private val comparisonCamposDeCacaRepository: edu.admafk.union.union_app.repository.ComparisonCamposDeCacaRepository) {

    fun findAllComparisonCamposDeCaca(): List<edu.admafk.union.union_app.entity.ComparisonCamposDeCaca> = comparisonCamposDeCacaRepository.findAll()

    fun findComparisonCamposDeCacaById(id: Long): edu.admafk.union.union_app.entity.ComparisonCamposDeCaca? = comparisonCamposDeCacaRepository.findById(id).orElse(null)

    fun findComparisonCamposDeCacaByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.ComparisonCamposDeCaca> = comparisonCamposDeCacaRepository.findByPlayerId(playerId)

    fun createComparisonCamposDeCaca(comparisonCamposDeCaca: edu.admafk.union.union_app.entity.ComparisonCamposDeCaca): edu.admafk.union.union_app.entity.ComparisonCamposDeCaca = comparisonCamposDeCacaRepository.save(comparisonCamposDeCaca)

    fun updateComparisonCamposDeCaca(id: Long, updatedComparisonCamposDeCaca: edu.admafk.union.union_app.entity.ComparisonCamposDeCaca): edu.admafk.union.union_app.entity.ComparisonCamposDeCaca? {
        val existingComparisonCamposDeCaca = comparisonCamposDeCacaRepository.findById(id).orElse(null) ?: return null
        val updatedComparisonCamposDeCacaEntity = existingComparisonCamposDeCaca.copy(
            hero = updatedComparisonCamposDeCaca.hero,
            numeroDaComp = updatedComparisonCamposDeCaca.numeroDaComp,
            posicaoNaComp = updatedComparisonCamposDeCaca.posicaoNaComp,
            instrucoes = updatedComparisonCamposDeCaca.instrucoes,
            pet = updatedComparisonCamposDeCaca.pet
        )
        return comparisonCamposDeCacaRepository.save(updatedComparisonCamposDeCacaEntity)
    }

    fun deleteComparisonCamposDeCaca(id: Long): Boolean {
        return if (comparisonCamposDeCacaRepository.existsById(id)) {
            comparisonCamposDeCacaRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
