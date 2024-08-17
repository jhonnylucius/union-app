package com.admafk.union.union_app.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "comparison_history")
data class ComparisonHistory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    val player: Player,

    @Column(name = "comparison_type", nullable = false)
    val comparisonType: String,

    @Column(name = "comparison_result", columnDefinition = "LONGTEXT")
    val comparisonResult: String,

    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now()
)
