package edu.admafk.union.union_app.service

import edu.admafk.union.union_app.entity.ComparisonMinas
import edu.admafk.union.union_app.repository.ComparisonMinasRepository
import org.springframework.stereotype.Service

@Service
class ComparisonMinasService(private val comparisonMinasRepository: edu.admafk.union.union_app.repository.ComparisonMinasRepository) {

    fun findAllComparisonMinas(): List<edu.admafk.union.union_app.entity.ComparisonMinas> = comparisonMinasRepository.findAll()

    fun findComparisonMinasById(id: Long): edu.admafk.union.union_app.entity.ComparisonMinas? = comparisonMinasRepository.findById(id).orElse(null)

    fun findComparisonMinasByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.ComparisonMinas> = comparisonMinasRepository.findByPlayerId(playerId)

    fun createComparisonMinas(comparisonMinas: edu.admafk.union.union_app.entity.ComparisonMinas): edu.admafk.union.union_app.entity.ComparisonMinas = comparisonMinasRepository.save(comparisonMinas)

    fun updateComparisonMinas(id: Long, updatedComparisonMinas: edu.admafk.union.union_app.entity.ComparisonMinas): edu.admafk.union.union_app.entity.ComparisonMinas? {
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
