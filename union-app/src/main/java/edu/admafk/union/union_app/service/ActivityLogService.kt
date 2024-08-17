package edu.admafk.union.union_app.service

import edu.admafk.union.union_app.entity.ActivityLog
import com.admafk.union.union_app.repository.ActivityLogRepository
import org.springframework.stereotype.Service

@Service
class ActivityLogService(private val activityLogRepository: ActivityLogRepository) {

    fun findAllActivityLogs(): List<edu.admafk.union.union_app.entity.ActivityLog> = activityLogRepository.findAll()

    fun findActivityLogById(id: Long): edu.admafk.union.union_app.entity.ActivityLog? = activityLogRepository.findById(id).orElse(null)

    fun findActivityLogsByUserId(userId: Long): List<edu.admafk.union.union_app.entity.ActivityLog> = activityLogRepository.findByUserId(userId)

    fun createActivityLog(activityLog: edu.admafk.union.union_app.entity.ActivityLog): edu.admafk.union.union_app.entity.ActivityLog = activityLogRepository.save(activityLog)

    fun updateActivityLog(id: Long, updatedActivityLog: edu.admafk.union.union_app.entity.ActivityLog): edu.admafk.union.union_app.entity.ActivityLog? {
        val existingActivityLog = activityLogRepository.findById(id).orElse(null) ?: return null
        val updatedActivityLogEntity = existingActivityLog.copy(
            action = updatedActivityLog.action,
            timestamp = updatedActivityLog.timestamp
        )
        return activityLogRepository.save(updatedActivityLogEntity)
    }

    fun deleteActivityLog(id: Long): Boolean {
        return if (activityLogRepository.existsById(id)) {
            activityLogRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
