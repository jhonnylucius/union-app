package com.admafk.union.union_app.repository

import com.admafk.union.union_app.entity.ActivityLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ActivityLogRepository : JpaRepository<ActivityLog, Long> {
    fun findByUserId(userId: Long): List<ActivityLog>
}
