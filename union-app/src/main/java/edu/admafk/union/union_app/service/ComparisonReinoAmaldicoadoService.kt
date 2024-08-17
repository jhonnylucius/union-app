package com.admafk.union.union_app.service

import com.admafk.union.union_app.entity.ComparisonReinoAmaldicoado
import com.admafk.union.union_app.repository.ComparisonReinoAmaldicoadoRepository
import org.springframework.stereotype.Service

@Service
class ComparisonReinoAmaldicoadoService(private val comparisonReinoAmaldicoadoRepository: ComparisonReinoAmaldicoadoRepository) {

    fun findAllComparisonReinoAmaldicoado(): List<ComparisonReinoAmaldicoado> = comparisonReinoAmaldicoadoRepository.findAll()

    fun findComparisonReinoAmaldicoadoById(id: Long): ComparisonReinoAmaldicoado? = comparisonReinoAmaldicoadoRepository.findById(id).orElse(null)

    fun findComparisonReinoAmaldicoadoByPlayerId(playerId: Long): List<ComparisonReinoAmaldicoado> = comparisonReinoAmaldicoadoRepository.findByPlayerId(playerId)

    fun createComparisonReinoAmaldicoado(comparisonReinoAmaldicoado: ComparisonReinoAmaldicoado): ComparisonReinoAmaldicoado = comparisonReinoAmaldicoadoRepository.save(comparisonReinoAmaldicoado)

    fun updateComparisonReinoAmaldicoado(id: Long, updatedComparisonReinoAmaldicoado: ComparisonReinoAmaldicoado): ComparisonReinoAmaldicoado? {
        val existingComparisonReinoAmaldicoado = comparisonReinoAmaldicoadoRepository.findById(id).orElse(null) ?: return null
        val updatedComparisonReinoAmaldicoadoEntity = existingComparisonReinoAmaldicoado.copy(
            hero = updatedComparisonReinoAmaldicoado.hero,
            numeroDaComp = updatedComparisonReinoAmaldicoado.numeroDaComp,
            posicaoNaComp = updatedComparisonReinoAmaldicoado.posicaoNaComp,
            instrucoes = updatedComparisonReinoAmaldicoado.instrucoes,
            pet = updatedComparisonReinoAmaldicoado.pet
        )
        return comparisonReinoAmaldicoadoRepository.save(updatedComparisonReinoAmaldicoadoEntity)
    }

    fun deleteComparisonReinoAmaldicoado(id: Long): Boolean {
        return if (comparisonReinoAmaldicoadoRepository.existsById(id)) {
            comparisonReinoAmaldicoadoRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
