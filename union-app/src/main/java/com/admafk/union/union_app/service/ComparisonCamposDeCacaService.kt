package com.admafk.union.union_app.service

import com.admafk.union.union_app.entity.ComparisonCamposDeCaca
import com.admafk.union.union_app.repository.ComparisonCamposDeCacaRepository
import org.springframework.stereotype.Service

@Service
class ComparisonCamposDeCacaService(private val comparisonCamposDeCacaRepository: ComparisonCamposDeCacaRepository) {

    fun findAllComparisonCamposDeCaca(): List<ComparisonCamposDeCaca> = comparisonCamposDeCacaRepository.findAll()

    fun findComparisonCamposDeCacaById(id: Long): ComparisonCamposDeCaca? = comparisonCamposDeCacaRepository.findById(id).orElse(null)

    fun findComparisonCamposDeCacaByPlayerId(playerId: Long): List<ComparisonCamposDeCaca> = comparisonCamposDeCacaRepository.findByPlayerId(playerId)

    fun createComparisonCamposDeCaca(comparisonCamposDeCaca: ComparisonCamposDeCaca): ComparisonCamposDeCaca = comparisonCamposDeCacaRepository.save(comparisonCamposDeCaca)

    fun updateComparisonCamposDeCaca(id: Long, updatedComparisonCamposDeCaca: ComparisonCamposDeCaca): ComparisonCamposDeCaca? {
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
