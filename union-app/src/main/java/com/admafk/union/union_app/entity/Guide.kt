package com.admafk.union.union_app.entity

import jakarta.persistence.*

@Entity
@Table(name = "guias_salvos")
data class Guide(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jogador_id", nullable = false)
    val player: Player,

    @Column(nullable = false, length = 255)
    val modo: String,

    @Column(columnDefinition = "TEXT")
    val conteudo: String
)
