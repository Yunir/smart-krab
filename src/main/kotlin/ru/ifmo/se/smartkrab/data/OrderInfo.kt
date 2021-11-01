package ru.ifmo.se.smartkrab.data

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

@Entity
class OrderInfo (
    var position: String = "Kraby Pattie",
    @field:NotNull(message = "Write value between 1 and 10")
    @field:Min(1, message = "value should be greater than 1")
    @field:Max(10, message = "value should be less than or equals to 10")
    var value: Int? = 1,
    var status: String = "registered",
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
) {
    override fun toString(): String {
        return "$id - $addedAt: $value x $position. Status: $status"
    }
}