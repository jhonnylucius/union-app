package com.admafk.union.union_app.repository

import com.admafk.union.union_app.entity.Guide
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GuideRepository : JpaRepository<Guide, Long> {
    fun findByPlayerId(playerId: Long): List<Guide>
}
