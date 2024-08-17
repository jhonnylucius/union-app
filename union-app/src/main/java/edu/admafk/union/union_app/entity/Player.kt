package com.admafk.union.union_app.entity

import jakarta.persistence.*

@Entity
@Table(name = "jogadores")
data class Player(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    val user: User,

    @Column(nullable = false, length = 255)
    val nome: String
)
