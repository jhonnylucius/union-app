package edu.admafk.union.union_app.service

import edu.admafk.union.union_app.entity.Guide
import edu.admafk.union.union_app.repository.GuideRepository
import org.springframework.stereotype.Service

@Service
class GuideService(private val guideRepository: edu.admafk.union.union_app.repository.GuideRepository) {

    fun findAllGuides(): List<edu.admafk.union.union_app.entity.Guide> = guideRepository.findAll()

    fun findGuideById(id: Long): edu.admafk.union.union_app.entity.Guide? = guideRepository.findById(id).orElse(null)

    fun findGuidesByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.Guide> = guideRepository.findByPlayerId(playerId)

    fun createGuide(guide: edu.admafk.union.union_app.entity.Guide): edu.admafk.union.union_app.entity.Guide = guideRepository.save(guide)

    fun updateGuide(id: Long, updatedGuide: edu.admafk.union.union_app.entity.Guide): edu.admafk.union.union_app.entity.Guide? {
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
