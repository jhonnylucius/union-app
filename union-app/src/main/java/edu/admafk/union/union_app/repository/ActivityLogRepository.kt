package edu.admafk.union.union_app.repository

import edu.admafk.union.union_app.entity.ActivityLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ActivityLogRepository : JpaRepository<edu.admafk.union.union_app.entity.ActivityLog, Long> {
    fun findByUserId(userId: Long): List<edu.admafk.union.union_app.entity.ActivityLog>
}
