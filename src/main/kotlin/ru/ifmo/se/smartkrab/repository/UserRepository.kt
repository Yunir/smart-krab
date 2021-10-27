package ru.ifmo.se.smartkrab.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.ui.Model
import ru.ifmo.se.smartkrab.data.User

interface UserRepository : CrudRepository<User, Long> {
    fun findByLogin(login: String): User
}