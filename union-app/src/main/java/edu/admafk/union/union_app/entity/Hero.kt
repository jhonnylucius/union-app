package edu.admafk.union.union_app.entity

import jakarta.persistence.*

@Entity
@Table(name = "herois")
data class Hero(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, length = 255)
    val nome: String,

    @Column(nullable = false, length = 255)
    val classe: String,

    @Column(nullable = false, length = 255)
    val faccao: String,

    @Column(columnDefinition = "TEXT")
    val urlImagem: String
)
