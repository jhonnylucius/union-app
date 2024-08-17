package edu.admafk.union.union_app.controller

import com.admafk.union.union_app.entity.ListaHeroisMetas
import com.admafk.union.union_app.service.ListaHeroisMetasService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/lista-herois-metas")
class ListaHeroisMetasController(private val listaHeroisMetasService: ListaHeroisMetasService) {

    @GetMapping
    fun getAllListaHeroisMetas(): ResponseEntity<List<ListaHeroisMetas>> {
        val listaHeroisMetas = listaHeroisMetasService.findAllListaHeroisMetas()
        return ResponseEntity.ok(listaHeroisMetas)
    }

    @GetMapping("/{id}")
    fun getListaHeroisMetasById(@PathVariable id: Long): ResponseEntity<ListaHeroisMetas> {
        val listaHeroisMetas = listaHeroisMetasService.findListaHeroisMetasById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(listaHeroisMetas)
    }

    @GetMapping("/user/{userId}")
    fun getListaHeroisMetasByUserId(@PathVariable userId: Long): ResponseEntity<List<ListaHeroisMetas>> {
        val listaHeroisMetas = listaHeroisMetasService.findListaHeroisMetasByUserId(userId)
        return ResponseEntity.ok(listaHeroisMetas)
    }

    @PostMapping
    fun createListaHeroisMetas(@RequestBody listaHeroisMetas: ListaHeroisMetas): ResponseEntity<ListaHeroisMetas> {
        val newListaHeroisMetas = listaHeroisMetasService.createListaHeroisMetas(listaHeroisMetas)
        return ResponseEntity.ok(newListaHeroisMetas)
    }

    @PutMapping("/{id}")
    fun updateListaHeroisMetas(@PathVariable id: Long, @RequestBody listaHeroisMetas: ListaHeroisMetas): ResponseEntity<ListaHeroisMetas> {
        val updatedListaHeroisMetas = listaHeroisMetasService.updateListaHeroisMetas(id, listaHeroisMetas) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedListaHeroisMetas)
    }

    @DeleteMapping("/{id}")
    fun deleteListaHeroisMetas(@PathVariable id: Long): ResponseEntity<Void> {
        return if (listaHeroisMetasService.deleteListaHeroisMetas(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
