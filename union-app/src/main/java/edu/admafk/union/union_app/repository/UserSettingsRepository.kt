package com.admafk.union.union_app.repository

import com.admafk.union.union_app.entity.UserSettings
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserSettingsRepository : JpaRepository<UserSettings, Long> {
    fun findByUserId(userId: Long): UserSettings?
}
