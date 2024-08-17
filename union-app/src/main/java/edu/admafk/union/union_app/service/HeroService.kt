package edu.admafk.union.union_app.service

import edu.admafk.union.union_app.entity.Hero
import edu.admafk.union.union_app.repository.HeroRepository
import org.springframework.stereotype.Service

@Service
class HeroService(private val heroRepository: edu.admafk.union.union_app.repository.HeroRepository) {

    fun findAllHeroes(): List<edu.admafk.union.union_app.entity.Hero> = heroRepository.findAll()

    fun findHeroById(id: Long): edu.admafk.union.union_app.entity.Hero? = heroRepository.findById(id).orElse(null)

    fun findHeroesByClasse(classe: String): List<edu.admafk.union.union_app.entity.Hero> = heroRepository.findByClasse(classe)

    fun findHeroesByFaccao(faccao: String): List<edu.admafk.union.union_app.entity.Hero> = heroRepository.findByFaccao(faccao)

    fun createHero(hero: edu.admafk.union.union_app.entity.Hero): edu.admafk.union.union_app.entity.Hero = heroRepository.save(hero)

    fun updateHero(id: Long, updatedHero: edu.admafk.union.union_app.entity.Hero): edu.admafk.union.union_app.entity.Hero? {
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
