package ru.ifmo.se.smartkrab.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class User(
        var login: String,
        var password: String,
        var role: Role,
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long? = null
) {
    override fun toString(): String {
        return "$id - $login $password, role = $role"
    }
}