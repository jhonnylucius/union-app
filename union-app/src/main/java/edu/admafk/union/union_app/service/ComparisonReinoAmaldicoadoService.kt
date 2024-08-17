package edu.admafk.union.union_app.service

import edu.admafk.union.union_app.entity.ComparisonReinoAmaldicoado
import edu.admafk.union.union_app.repository.ComparisonReinoAmaldicoadoRepository
import org.springframework.stereotype.Service

@Service
class ComparisonReinoAmaldicoadoService(private val comparisonReinoAmaldicoadoRepository: edu.admafk.union.union_app.repository.ComparisonReinoAmaldicoadoRepository) {

    fun findAllComparisonReinoAmaldicoado(): List<edu.admafk.union.union_app.entity.ComparisonReinoAmaldicoado> = comparisonReinoAmaldicoadoRepository.findAll()

    fun findComparisonReinoAmaldicoadoById(id: Long): edu.admafk.union.union_app.entity.ComparisonReinoAmaldicoado? = comparisonReinoAmaldicoadoRepository.findById(id).orElse(null)

    fun findComparisonReinoAmaldicoadoByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.ComparisonReinoAmaldicoado> = comparisonReinoAmaldicoadoRepository.findByPlayerId(playerId)

    fun createComparisonReinoAmaldicoado(comparisonReinoAmaldicoado: edu.admafk.union.union_app.entity.ComparisonReinoAmaldicoado): edu.admafk.union.union_app.entity.ComparisonReinoAmaldicoado = comparisonReinoAmaldicoadoRepository.save(comparisonReinoAmaldicoado)

    fun updateComparisonReinoAmaldicoado(id: Long, updatedComparisonReinoAmaldicoado: edu.admafk.union.union_app.entity.ComparisonReinoAmaldicoado): edu.admafk.union.union_app.entity.ComparisonReinoAmaldicoado? {
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
