package com.admafk.union.union_app.controller

import com.admafk.union.union_app.entity.ActivityLog
import com.admafk.union.union_app.service.ActivityLogService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/activity-log")
class ActivityLogController(private val activityLogService: ActivityLogService) {

    @GetMapping
    fun getAllActivityLogs(): ResponseEntity<List<ActivityLog>> {
        val activityLogs = activityLogService.findAllActivityLogs()
        return ResponseEntity.ok(activityLogs)
    }

    @GetMapping("/{id}")
    fun getActivityLogById(@PathVariable id: Long): ResponseEntity<ActivityLog> {
        val activityLog = activityLogService.findActivityLogById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(activityLog)
    }

    @GetMapping("/user/{userId}")
    fun getActivityLogsByUserId(@PathVariable userId: Long): ResponseEntity<List<ActivityLog>> {
        val activityLogs = activityLogService.findActivityLogsByUserId(userId)
        return ResponseEntity.ok(activityLogs)
    }

    @PostMapping
    fun createActivityLog(@RequestBody activityLog: ActivityLog): ResponseEntity<ActivityLog> {
        val newActivityLog = activityLogService.createActivityLog(activityLog)
        return ResponseEntity.ok(newActivityLog)
    }

    @PutMapping("/{id}")
    fun updateActivityLog(@PathVariable id: Long, @RequestBody activityLog: ActivityLog): ResponseEntity<ActivityLog> {
        val updatedActivityLog = activityLogService.updateActivityLog(id, activityLog) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(updatedActivityLog)
    }

    @DeleteMapping("/{id}")
    fun deleteActivityLog(@PathVariable id: Long): ResponseEntity<Void> {
        return if (activityLogService.deleteActivityLog(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
