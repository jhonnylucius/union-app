package com.admafk.union.union_app.dto

data class ComparisonMinasDTO(
    val id: Long?,
    val heroiId: Long,
    val numeroDaComp: Int,
    val posicaoNaComp: Int,
    val instrucoes: String,
    val petId: Long?,
    val jogadorId: Long
)
