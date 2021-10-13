package ru.ifmo.se.smartkrab.repository

import org.springframework.data.repository.CrudRepository
import ru.ifmo.se.smartkrab.data.User

interface UserRepository : CrudRepository<User, Long> {
}