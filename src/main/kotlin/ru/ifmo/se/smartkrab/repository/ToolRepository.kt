package ru.ifmo.se.smartkrab.repository

import org.springframework.data.repository.CrudRepository
import ru.ifmo.se.smartkrab.data.Tool

interface ToolRepository : CrudRepository<Tool, Long> {
    fun findByName(name: String): Tool
}