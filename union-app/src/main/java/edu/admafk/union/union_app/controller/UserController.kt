package edu.admafk.union.union_app.controller

import com.admafk.union.union_app.entity.User
import com.admafk.union.union_app.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>> {
        val users = userService.findAllUsers()
        return ResponseEntity.ok(users)
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        val user = userService.findUserById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(user)
    }

    @PostMapping
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        val newUser = userService.createUser(user)
        return ResponseEntity.ok(newUser)
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: User): ResponseEntity<User> {
        val updatedUser = userService.updateUser(id, user) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedUser)
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        return if (userService.deleteUser(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
