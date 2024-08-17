package edu.admafk.union.union_app.repository

import edu.admafk.union.union_app.entity.UserSettings
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserSettingsRepository : JpaRepository<edu.admafk.union.union_app.entity.UserSettings, Long> {
    fun findByUserId(userId: Long): edu.admafk.union.union_app.entity.UserSettings?
}
