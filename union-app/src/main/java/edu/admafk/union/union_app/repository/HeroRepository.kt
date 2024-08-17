package edu.admafk.union.union_app.repository

import edu.admafk.union.union_app.entity.Hero
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HeroRepository : JpaRepository<edu.admafk.union.union_app.entity.Hero, Long> {
    fun findByClasse(classe: String): List<edu.admafk.union.union_app.entity.Hero>
    fun findByFaccao(faccao: String): List<edu.admafk.union.union_app.entity.Hero>
}
