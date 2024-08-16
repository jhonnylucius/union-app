package com.admafk.union.union_app.service

import com.admafk.union.union_app.entity.ListaHeroisMetas
import com.admafk.union.union_app.repository.ListaHeroisMetasRepository
import org.springframework.stereotype.Service

@Service
class ListaHeroisMetasService(private val listaHeroisMetasRepository: ListaHeroisMetasRepository) {

    fun findAllListaHeroisMetas(): List<ListaHeroisMetas> = listaHeroisMetasRepository.findAll()

    fun findListaHeroisMetasById(id: Long): ListaHeroisMetas? = listaHeroisMetasRepository.findById(id).orElse(null)

    fun findListaHeroisMetasByUserId(userId: Long): List<ListaHeroisMetas> = listaHeroisMetasRepository.findByUserId(userId)

    fun createListaHeroisMetas(listaHeroisMetas: ListaHeroisMetas): ListaHeroisMetas = listaHeroisMetasRepository.save(listaHeroisMetas)

    fun updateListaHeroisMetas(id: Long, updatedListaHeroisMetas: ListaHeroisMetas): ListaHeroisMetas? {
        val existingListaHeroisMetas = listaHeroisMetasRepository.findById(id).orElse(null) ?: return null
        val updatedListaHeroisMetasEntity = existingListaHeroisMetas.copy(
            nomeDaLista = updatedListaHeroisMetas.nomeDaLista,
            checked = updatedListaHeroisMetas.checked
        )
        return listaHeroisMetasRepository.save(updatedListaHeroisMetasEntity)
    }

    fun deleteListaHeroisMetas(id: Long): Boolean {
        return if (listaHeroisMetasRepository.existsById(id)) {
            listaHeroisMetasRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
