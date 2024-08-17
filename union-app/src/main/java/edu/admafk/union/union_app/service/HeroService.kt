package com.admafk.union.union_app.service

import com.admafk.union.union_app.entity.Hero
import com.admafk.union.union_app.repository.HeroRepository
import org.springframework.stereotype.Service

@Service
class HeroService(private val heroRepository: HeroRepository) {

    fun findAllHeroes(): List<Hero> = heroRepository.findAll()

    fun findHeroById(id: Long): Hero? = heroRepository.findById(id).orElse(null)

    fun findHeroesByClasse(classe: String): List<Hero> = heroRepository.findByClasse(classe)

    fun findHeroesByFaccao(faccao: String): List<Hero> = heroRepository.findByFaccao(faccao)

    fun createHero(hero: Hero): Hero = heroRepository.save(hero)

    fun updateHero(id: Long, updatedHero: Hero): Hero? {
        val existingHero = heroRepository.findById(id).orElse(null) ?: return null
        val updatedHeroEntity = existingHero.copy(
            nome = updatedHero.nome,
            classe = updatedHero.classe,
            faccao = updatedHero.faccao,
            urlImagem = updatedHero.urlImagem
        )
        return heroRepository.save(updatedHeroEntity)
    }

    fun deleteHero(id: Long): Boolean {
        return if (heroRepository.existsById(id)) {
            heroRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
