package com.admafk.union.union_app.dto

data class ListaHeroisMetasDTO(
    val id: Long?,
    val nomeDaLista: String,
    val userId: Long,
    val heroiId: Long,
    val checked: Boolean
)
