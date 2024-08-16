package com.admafk.union.union_app.service

import com.admafk.union.union_app.entity.Guide
import com.admafk.union.union_app.repository.GuideRepository
import org.springframework.stereotype.Service

@Service
class GuideService(private val guideRepository: GuideRepository) {

    fun findAllGuides(): List<Guide> = guideRepository.findAll()

    fun findGuideById(id: Long): Guide? = guideRepository.findById(id).orElse(null)

    fun findGuidesByPlayerId(playerId: Long): List<Guide> = guideRepository.findByPlayerId(playerId)

    fun createGuide(guide: Guide): Guide = guideRepository.save(guide)

    fun updateGuide(id: Long, updatedGuide: Guide): Guide? {
        val existingGuide = guideRepository.findById(id).orElse(null) ?: return null
        val updatedGuideEntity = existingGuide.copy(
            modo = updatedGuide.modo,
            conteudo = updatedGuide.conteudo
        )
        return guideRepository.save(updatedGuideEntity)
    }

    fun deleteGuide(id: Long): Boolean {
        return if (guideRepository.existsById(id)) {
            guideRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
