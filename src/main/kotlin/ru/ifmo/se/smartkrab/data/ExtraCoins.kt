package ru.ifmo.se.smartkrab.data

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class ExtraCoins(
    var value: Int,
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null
) {
    override fun toString(): String {
        return "$id - $addedAt: $value$"
    }
}