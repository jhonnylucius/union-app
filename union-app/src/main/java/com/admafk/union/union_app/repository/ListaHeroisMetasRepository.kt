package com.admafk.union.union_app.repository

import com.admafk.union.union_app.entity.ListaHeroisMetas
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ListaHeroisMetasRepository : JpaRepository<ListaHeroisMetas, Long> {
    fun findByUserId(userId: Long): List<ListaHeroisMetas>
}
