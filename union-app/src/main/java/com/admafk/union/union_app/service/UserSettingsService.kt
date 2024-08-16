package com.admafk.union.union_app.service

import com.admafk.union.union_app.entity.UserSettings
import com.admafk.union.union_app.repository.UserSettingsRepository
import org.springframework.stereotype.Service

@Service
class UserSettingsService(private val userSettingsRepository: UserSettingsRepository) {

    fun findAllUserSettings(): List<UserSettings> = userSettingsRepository.findAll()

    fun findUserSettingsById(id: Long): UserSettings? = userSettingsRepository.findById(id).orElse(null)

    fun findUserSettingsByUserId(userId: Long): UserSettings? = userSettingsRepository.findByUserId(userId)

    fun createUserSettings(userSettings: UserSettings): UserSettings = userSettingsRepository.save(userSettings)

    fun updateUserSettings(id: Long, updatedUserSettings: UserSettings): UserSettings? {
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
