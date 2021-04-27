package ru.ifmo.se.smartkrab

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SmartKrabApplication

fun main(args: Array<String>) {
	runApplication<SmartKrabApplication>(*args)
}
