package edu.admafk.union.union_app.entity

import jakarta.persistence.*

@Entity
@Table(name = "lista_herois_metas")
data class ListaHeroisMetas(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "nome_da_lista", nullable = false, length = 255)
    val nomeDaLista: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "heroi_id", nullable = false)
    val hero: Hero,

    @Column(nullable = false)
    val checked: Boolean = false
)
