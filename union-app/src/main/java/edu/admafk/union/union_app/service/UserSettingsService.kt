package edu.admafk.union.union_app.service

import edu.admafk.union.union_app.entity.UserSettings
import edu.admafk.union.union_app.repository.UserSettingsRepository
import org.springframework.stereotype.Service

@Service
class UserSettingsService(private val userSettingsRepository: edu.admafk.union.union_app.repository.UserSettingsRepository) {

    fun findAllUserSettings(): List<edu.admafk.union.union_app.entity.UserSettings> = userSettingsRepository.findAll()

    fun findUserSettingsById(id: Long): edu.admafk.union.union_app.entity.UserSettings? = userSettingsRepository.findById(id).orElse(null)

    fun findUserSettingsByUserId(userId: Long): edu.admafk.union.union_app.entity.UserSettings? = userSettingsRepository.findByUserId(userId)

    fun createUserSettings(userSettings: edu.admafk.union.union_app.entity.UserSettings): edu.admafk.union.union_app.entity.UserSettings = userSettingsRepository.save(userSettings)

    fun updateUserSettings(id: Long, updatedUserSettings: edu.admafk.union.union_app.entity.UserSettings): edu.admafk.union.union_app.entity.UserSettings? {
        val existingUserSettings = userSettingsRepository.findById(id).orElse(null) ?: return null
        val updatedUserSettingsEntity = existingUserSettings.copy(
            settings = updatedUserSettings.settings,
            updatedAt = updatedUserSettings.updatedAt
        )
        return userSettingsRepository.save(updatedUserSettingsEntity)
    }

    fun deleteUserSettings(id: Long): Boolean {
        return if (userSettingsRepository.existsById(id)) {
            userSettingsRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
