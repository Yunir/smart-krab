package ru.ifmo.se.smartkrab.service

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.ui.Model
import ru.ifmo.se.smartkrab.data.Role
import ru.ifmo.se.smartkrab.data.User
import ru.ifmo.se.smartkrab.repository.UserRepository

@Service
class UserService(val uRepo: UserRepository, val passwordEncoder: PasswordEncoder) {

    fun getUser(model: Model): String {
        model.addAttribute("user", User("", "", Role.ROLE_CHEF))
        return "new-user"
    }

    fun addNewUser(model: Model, user: User): String {
        model.addAttribute("user", user)
        user.password = passwordEncoder.encode(user.password)
        uRepo.save(user)

        println("Users found with findAll():")
        println("-------------------------------")
        for (e in uRepo.findAll()) {
            println(e.toString())
        }
        println("")

        return "new-user-submit"
    }
}