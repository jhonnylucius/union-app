package com.admafk.union.union_app.entity

import jakarta.persistence.*
import org.springframework.security.core.userdetails.User
import java.time.LocalDateTime

@Entity
@Table(name = "activity_log")
data class ActivityLog(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @Column(nullable = false, length = 255)
    val action: String,

    @Column(nullable = false)
    val timestamp: LocalDateTime = LocalDateTime.now()
)
