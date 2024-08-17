package edu.admafk.union.union_app.entity

import jakarta.persistence.*

@Entity
@Table(name = "pets")
data class Pet(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, length = 255)
    val nome: String,

    @Column(columnDefinition = "TEXT")
    val urlPet: String
)
