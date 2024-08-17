package edu.admafk.union.union_app.controller

import edu.admafk.union.union_app.entity.UserSettings
import com.admafk.union.union_app.service.UserSettingsService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/user-settings")
class UserSettingsController(private val userSettingsService: UserSettingsService) {

    @GetMapping
    fun getAllUserSettings(): ResponseEntity<List<edu.admafk.union.union_app.entity.UserSettings>> {
        val userSettings = userSettingsService.findAllUserSettings()
        return ResponseEntity.ok(userSettings)
    }

    @GetMapping("/{id}")
    fun getUserSettingsById(@PathVariable id: Long): ResponseEntity<edu.admafk.union.union_app.entity.UserSettings> {
        val userSettings = userSettingsService.findUserSettingsById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(userSettings)
    }

    @GetMapping("/user/{userId}")
    fun getUserSettingsByUserId(@PathVariable userId: Long): ResponseEntity<edu.admafk.union.union_app.entity.UserSettings> {
        val userSettings = userSettingsService.findUserSettingsByUserId(userId) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(userSettings)
    }

    @PostMapping
    fun createUserSettings(@RequestBody userSettings: edu.admafk.union.union_app.entity.UserSettings): ResponseEntity<edu.admafk.union.union_app.entity.UserSettings> {
        val newUserSettings = userSettingsService.createUserSettings(userSettings)
        return ResponseEntity.ok(newUserSettings)
    }

    @PutMapping("/{id}")
    fun updateUserSettings(@PathVariable id: Long, @RequestBody userSettings: edu.admafk.union.union_app.entity.UserSettings): ResponseEntity<edu.admafk.union.union_app.entity.UserSettings> {
        val updatedUserSettings = userSettingsService.updateUserSettings(id, userSettings) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedUserSettings)
    }

    @DeleteMapping("/{id}")
    fun deleteUserSettings(@PathVariable id: Long): ResponseEntity<Void> {
        return if (userSettingsService.deleteUserSettings(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
