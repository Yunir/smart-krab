package ru.ifmo.se.smartkrab

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.password.PasswordEncoder
import ru.ifmo.se.smartkrab.repository.ExtraCoinsRepository
import ru.ifmo.se.smartkrab.repository.OrderRepository
import ru.ifmo.se.smartkrab.repository.UserRepository


fun main(args: Array<String>) {
    runApplication<SmartKrabApplication>(*args)
}

@SpringBootApplication
class SmartKrabApplication {

    @Bean
    fun someExtraCoins(ecRepo: ExtraCoinsRepository): CommandLineRunner {
        return CommandLineRunner {
            // save some coins
//            ecRepo.save(ExtraCoins(5))
//            ecRepo.save(ExtraCoins(1))
//            ecRepo.save(ExtraCoins(7))
//            ecRepo.save(ExtraCoins(2))

            // fetch coins from database
            println("ExtraCoins found with findAll():")
            println("-------------------------------")
            println(ecRepo.findAll().joinToString("\n"))
            println("")
        }
    }

    @Bean
    fun someOrders(oRepo: OrderRepository): CommandLineRunner {
        return CommandLineRunner {
            // save some orders
            // oRepo.save(OrderInfo(value = 5))

            println("Orders found with findAll():")
            println("-------------------------------")
            println(oRepo.findAll().joinToString("\n"))
            println("")
        }
    }

    @Bean
    fun ownerUser(uRepo: UserRepository, passwordEncoder: PasswordEncoder): CommandLineRunner {
        return CommandLineRunner {
//            passwordEncoder.encode("krab")
//                ?.let { User(login = "krusty", password = it, role = Role.ROLE_OWNER, enabled = true) }
//                ?.let { uRepo.save(it) }
//
//            passwordEncoder.encode("test")
//                ?.let { User(login = "test", password = it, role = Role.ROLE_CASHIER, enabled = true) }
//                ?.let { uRepo.save(it) }
//
//            passwordEncoder.encode("chef")
//                ?.let { User(login = "chef", password = it, role = Role.ROLE_CHEF, enabled = true) }
//                ?.let { uRepo.save(it) }

            println("Users found with findAll():")
            println("-------------------------------")
            println(uRepo.findAll().joinToString("\n"))
            println("")
        }
    }
}

