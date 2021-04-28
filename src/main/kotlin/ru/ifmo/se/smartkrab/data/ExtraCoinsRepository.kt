package ru.ifmo.se.smartkrab.data

import org.springframework.data.repository.CrudRepository
import java.time.LocalDateTime

interface ExtraCoinsRepository : CrudRepository<ExtraCoins, Long> {
    fun findByAddedAt(localDateTime: LocalDateTime): List<ExtraCoins>
}