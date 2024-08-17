package edu.admafk.union.union_app.entity

import jakarta.persistence.*

@Entity
@Table(name = "jogadores_herois")
data class PlayerHero(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jogador_id", nullable = false)
    val player: Player,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "heroi_id", nullable = false)
    val hero: Hero
)
