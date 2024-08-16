package com.admafk.union.union_app.service

import com.admafk.union.union_app.entity.ComparisonHistory
import com.admafk.union.union_app.repository.ComparisonHistoryRepository
import org.springframework.stereotype.Service

@Service
class ComparisonHistoryService(private val comparisonHistoryRepository: ComparisonHistoryRepository) {

    fun findAllComparisonHistories(): List<ComparisonHistory> = comparisonHistoryRepository.findAll()

    fun findComparisonHistoryById(id: Long): ComparisonHistory? = comparisonHistoryRepository.findById(id).orElse(null)

    fun findComparisonHistoriesByPlayerId(playerId: Long): List<ComparisonHistory> = comparisonHistoryRepository.findByPlayerId(playerId)

    fun createComparisonHistory(comparisonHistory: ComparisonHistory): ComparisonHistory = comparisonHistoryRepository.save(comparisonHistory)

    fun updateComparisonHistory(id: Long, updatedComparisonHistory: ComparisonHistory): ComparisonHistory? {
        val existingComparisonHistory = comparisonHistoryRepository.findById(id).orElse(null) ?: return null
        val updatedComparisonHistoryEntity = existingComparisonHistory.copy(
            comparisonType = updatedComparisonHistory.comparisonType,
            comparisonResult = updatedComparisonHistory.comparisonResult
        )
        return comparisonHistoryRepository.save(updatedComparisonHistoryEntity)
    }

    fun deleteComparisonHistory(id: Long): Boolean {
        return if (comparisonHistoryRepository.existsById(id)) {
            comparisonHistoryRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
