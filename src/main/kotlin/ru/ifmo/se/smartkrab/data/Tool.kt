package ru.ifmo.se.smartkrab.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull


@Entity
class Tool(
        var name: String,
        @field:NotNull(message = "Write value between 1 and 5000")
        @field:Min(1, message = "value should be greater than 1")
        @field:Max(1000, message = "value should be less than 1000")
        var status: Int? = 1000,
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null
) {
    override fun toString(): String {
        return "$id - $name. Status: $status"
    }
}