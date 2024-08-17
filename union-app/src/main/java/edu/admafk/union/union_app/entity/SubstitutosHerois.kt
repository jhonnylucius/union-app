package edu.admafk.union.union_app.entity

import jakarta.persistence.*

@Entity
@Table(name = "substitutos_herois")
data class SubstitutosHerois(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "heroi_substituto_id", nullable = false)
    val heroSubstituto: Hero,

    @Column(nullable = false, length = 255)
    val classe: String,

    @Column(columnDefinition = "TEXT")
    val descricao: String
)
