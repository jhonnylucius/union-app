package com.admafk.union.union_app.service

import com.admafk.union.union_app.entity.User
import com.admafk.union.union_app.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Service
class UserService(private val userRepository: UserRepository) {

    private val passwordEncoder = BCryptPasswordEncoder()

    fun findAllUsers(): List<User> = userRepository.findAll()

    fun findUserById(id: Long): User? = userRepository.findById(id).orElse(null)

    fun findUserByEmail(email: String): User? = userRepository.findByEmail(email)

    fun createUser(user: User): User {
        val encryptedPassword = passwordEncoder.encode(user.senha)
        val newUser = user.copy(senha = encryptedPassword)
        return userRepository.save(newUser)
    }

    fun updateUser(id: Long, updatedUser: User): User? {
        val existingUser = userRepository.findById(id).orElse(null) ?: return null
        val updatedUserEntity = existingUser.copy(
            nome = updatedUser.nome,
            email = updatedUser.email,
            senha = passwordEncoder.encode(updatedUser.senha)
        )
        return userRepository.save(updatedUserEntity)
    }

    fun deleteUser(id: Long): Boolean {
        return if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
