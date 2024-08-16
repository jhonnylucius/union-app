package com.admafk.union.union_app.repository

import com.admafk.union.union_app.entity.Hero
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HeroRepository : JpaRepository<Hero, Long> {
    fun findByClasse(classe: String): List<Hero>
    fun findByFaccao(faccao: String): List<Hero>
}
