package com.admafk.union.union_app.entity

import jakarta.persistence.*

@Entity
@Table(name = "comparacao_campos_de_caca")
data class ComparisonCamposDeCaca(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "heroi_id", nullable = false)
    val hero: Hero,

    @Column(name = "numero_da_comp", nullable = false)
    val numeroDaComp: Int,

    @Column(name = "posicao_na_comp", nullable = false)
    val posicaoNaComp: Int,

    @Column(columnDefinition = "TEXT")
    val instrucoes: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    val pet: Pet? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jogador_id", nullable = false)
    val player: Player
)
