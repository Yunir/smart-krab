package ru.ifmo.se.smartkrab

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class SmartKrabApplication {
    @GetMapping("/add-user")
    fun addUser(
        @RequestParam(value = "name", defaultValue = "World") name: String
    ): String {
        return "Add user: $name"
    }
}

fun main(args: Array<String>) {
    runApplication<SmartKrabApplication>(*args)
}

