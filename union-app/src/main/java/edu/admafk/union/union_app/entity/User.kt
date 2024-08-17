package edu.admafk.union.union_app.entity

import jakarta.persistence.*

@Entity
@Table(name = "usuarios")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, length = 255)
    val nome: String,

    @Column(nullable = false, length = 255, unique = true)
    val email: String,

    @Column(nullable = false, length = 255)
    val senha: String
) {
    constructor() : this() {

    }
}
