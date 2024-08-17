package edu.admafk.union.union_app.repository

import edu.admafk.union.union_app.entity.Guide
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GuideRepository : JpaRepository<edu.admafk.union.union_app.entity.Guide, Long> {
    fun findByPlayerId(playerId: Long): List<edu.admafk.union.union_app.entity.Guide>
}
