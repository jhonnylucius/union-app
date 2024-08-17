package edu.admafk.union.union_app.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "performance_reports")
data class PerformanceReports(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    val player: Player,

    @Column(name = "report_data", columnDefinition = "JSON")
    val reportData: String,

    @Column(name = "generated_at", nullable = false)
    val generatedAt: LocalDateTime = LocalDateTime.now()
)
