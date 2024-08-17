package edu.admafk.union.union_app.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "favorite_heroes")
data class FavoriteHeroes(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", nullable = false)
    val player: Player,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "heroi_id", nullable = false)
    val hero: edu.admafk.union.union_app.entity.Hero,

    @Column(name = "added_at", nullable = false)
    val addedAt: LocalDateTime = LocalDateTime.now()
)
