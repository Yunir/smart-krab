package ru.ifmo.se.smartkrab.repository

import org.springframework.data.repository.CrudRepository
import ru.ifmo.se.smartkrab.data.AntiPlanktonStatus
import ru.ifmo.se.smartkrab.data.ExtraCoins
import java.time.LocalDateTime

interface AntiPlanktonRepository : CrudRepository<AntiPlanktonStatus, Long> {
}