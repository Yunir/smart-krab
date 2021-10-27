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
//            ecRepo.save(ExtraCoins(5))

            printReportToCLI("ExtraCoins", ecRepo.findAll().toList())
        }
    }

    @Bean
    fun someOrders(oRepo: OrderRepository): CommandLineRunner {
        return CommandLineRunner {
            // oRepo.save(OrderInfo(value = 5))

            printReportToCLI("Orders", oRepo.findAll().toList())
        }
    }

    @Bean
    fun ownerUser(uRepo: UserRepository, passwordEncoder: PasswordEncoder): CommandLineRunner {
        return CommandLineRunner {
//            passwordEncoder.encode("krab")
//                ?.let { User(login = "krusty", password = it, role = Role.ROLE_OWNER, enabled = true) }
//                ?.let { uRepo.save(it) }

            printReportToCLI("Users", uRepo.findAll().toList())
        }
    }
}
