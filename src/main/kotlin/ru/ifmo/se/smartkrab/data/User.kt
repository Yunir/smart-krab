package ru.ifmo.se.smartkrab.data

import javax.persistence.*


@Entity(name = "krab_user")
class User(
        var login: String,
        var password: String,
        @Enumerated(EnumType.STRING)
        var role: Role,
        var enabled: Boolean = true,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
) {
    override fun toString(): String {
        return "$id - $login $password, role = $role"
    }
}