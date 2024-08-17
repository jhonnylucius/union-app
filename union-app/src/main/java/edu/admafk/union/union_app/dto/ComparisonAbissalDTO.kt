package edu.admafk.union.union_app.dto

data class ComparisonAbissalDTO(
    val id: Long?,
    val heroiId: Long,
    val numeroDaComp: Int,
    val posicaoNaComp: Int,
    val instrucoes: String,
    val petId: Long?,
    val jogadorId: Long
)
