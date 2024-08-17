package edu.admafk.union.union_app.service

import com.admafk.union.union_app.entity.SubstitutosHerois
import edu.admafk.union.union_app.repository.SubstitutosHeroisRepository
import org.springframework.stereotype.Service

@Service
class SubstitutosHeroisService(private val substitutosHeroisRepository: edu.admafk.union.union_app.repository.SubstitutosHeroisRepository) {

    fun findAllSubstitutosHerois(): List<SubstitutosHerois> = substitutosHeroisRepository.findAll()

    fun findSubstitutoHeroiById(id: Long): SubstitutosHerois? = substitutosHeroisRepository.findById(id).orElse(null)

    fun createSubstitutoHeroi(substitutoHeroi: SubstitutosHerois): SubstitutosHerois = substitutosHeroisRepository.save(substitutoHeroi)

    fun updateSubstitutoHeroi(id: Long, updatedSubstitutoHeroi: SubstitutosHerois): SubstitutosHerois? {
        val existingSubstitutoHeroi = substitutosHeroisRepository.findById(id).orElse(null) ?: return null
        val updatedSubstitutoHeroiEntity = existingSubstitutoHeroi.copy(
            classe = updatedSubstitutoHeroi.classe,
            descricao = updatedSubstitutoHeroi.descricao
        )
        return substitutosHeroisRepository.save(updatedSubstitutoHeroiEntity)
    }

    fun deleteSubstitutoHeroi(id: Long): Boolean {
        return if (substitutosHeroisRepository.existsById(id)) {
            substitutosHeroisRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
