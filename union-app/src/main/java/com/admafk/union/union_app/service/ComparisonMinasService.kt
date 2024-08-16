package com.admafk.union.union_app.service

import com.admafk.union.union_app.entity.ComparisonMinas
import com.admafk.union.union_app.repository.ComparisonMinasRepository
import org.springframework.stereotype.Service

@Service
class ComparisonMinasService(private val comparisonMinasRepository: ComparisonMinasRepository) {

    fun findAllComparisonMinas(): List<ComparisonMinas> = comparisonMinasRepository.findAll()

    fun findComparisonMinasById(id: Long): ComparisonMinas? = comparisonMinasRepository.findById(id).orElse(null)

    fun findComparisonMinasByPlayerId(playerId: Long): List<ComparisonMinas> = comparisonMinasRepository.findByPlayerId(playerId)

    fun createComparisonMinas(comparisonMinas: ComparisonMinas): ComparisonMinas = comparisonMinasRepository.save(comparisonMinas)

    fun updateComparisonMinas(id: Long, updatedComparisonMinas: ComparisonMinas): ComparisonMinas? {
        val existingComparisonMinas = comparisonMinasRepository.findById(id).orElse(null) ?: return null
        val updatedComparisonMinasEntity = existingComparisonMinas.copy(
            hero = updatedComparisonMinas.hero,
            numeroDaComp = updatedComparisonMinas.numeroDaComp,
            posicaoNaComp = updatedComparisonMinas.posicaoNaComp,
            instrucoes = updatedComparisonMinas.instrucoes,
            pet = updatedComparisonMinas.pet
        )
        return comparisonMinasRepository.save(updatedComparisonMinasEntity)
    }

    fun deleteComparisonMinas(id: Long): Boolean {
        return if (comparisonMinasRepository.existsById(id)) {
            comparisonMinasRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
