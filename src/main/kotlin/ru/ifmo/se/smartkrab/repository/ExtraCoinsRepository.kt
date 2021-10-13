package ru.ifmo.se.smartkrab.repository

import org.springframework.data.repository.CrudRepository
import ru.ifmo.se.smartkrab.data.ExtraCoins
import java.time.LocalDateTime

interface ExtraCoinsRepository : CrudRepository<ExtraCoins, Long> {
    fun findByAddedAt(localDateTime: LocalDateTime): List<ExtraCoins>
}