package ru.ifmo.se.smartkrab.data

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.*


@Entity
class AntiPlanktonStatus(
    @field:NotNull(message = "Set current status")
    var status: Boolean? = false,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
)
