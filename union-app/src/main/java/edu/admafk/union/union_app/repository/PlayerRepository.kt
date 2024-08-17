package com.admafk.union.union_app.repository

import com.admafk.union.union_app.entity.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository : JpaRepository<Player, Long> {
    fun findByUserId(userId: Long): List<Player>
}
