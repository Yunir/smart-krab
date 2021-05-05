package ru.ifmo.se.smartkrab.data

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.*


@Entity
class ExtraCoins(
    @field:NotNull(message = "Write value between 1 and 5000")
    @field:Min(1, message = "value should be greater than 1")
    @field:Max(5000, message = "value should be less than 5000")
    var value: Int? = 0,
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null
) {
    override fun toString(): String {
        return "$id - $addedAt: $value$"
    }
}