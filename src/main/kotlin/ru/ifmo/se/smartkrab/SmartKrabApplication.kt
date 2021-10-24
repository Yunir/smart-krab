package ru.ifmo.se.smartkrab

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.password.PasswordEncoder
import ru.ifmo.se.smartkrab.data.ExtraCoins
import ru.ifmo.se.smartkrab.data.OrderInfo
import ru.ifmo.se.smartkrab.data.Role
import ru.ifmo.se.smartkrab.data.User
import ru.ifmo.se.smartkrab.repository.ExtraCoinsRepository
import ru.ifmo.se.smartkrab.repository.OrderRepository
import ru.ifmo.se.smartkrab.repository.UserRepository


@SpringBootApplication
class SmartKrabApplication {
/*
    @Bean
    fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner? {
        return CommandLineRunner { args: Array<String?>? ->
            println("Let's inspect the beans provided by Spring Boot:")
            val beanNames: Array<String> = ctx.beanDefinitionNames
            Arrays.sort(beanNames)
            for (beanName in beanNames) {
                println(beanName)
            }
        }
    }
*/

    @Bean
    fun someExtraCoins(ecRepo: ExtraCoinsRepository): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            // save some coins
            ecRepo.save(ExtraCoins(5))
            ecRepo.save(ExtraCoins(1))
            ecRepo.save(ExtraCoins(7))
            ecRepo.save(ExtraCoins(2))

            // fetch coins
            println("ExtraCoins found with findAll():")
            println("-------------------------------")
            for (extraCoins in ecRepo.findAll()) {
                println(extraCoins.toString())
            }
            println("")
        }
    }

    @Bean
    fun someOrders(oRepo: OrderRepository): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            // save some orders
            oRepo.save(OrderInfo(value = 5))

            println("Orders found with findAll():")
            println("-------------------------------")
            for (extraCoins in oRepo.findAll()) {
                println(extraCoins.toString())
            }
            println("")
        }
    }

    @Bean
    fun ownerUser(uRepo: UserRepository, passwordEncoder: PasswordEncoder): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            passwordEncoder.encode("krab")?.let { User(login = "krusty", password = it, role = Role.ROLE_OWNER, enabled = true) }?.let { uRepo.save(it) }

            passwordEncoder.encode("test")?.let { User(login = "test", password = it, role = Role.ROLE_CASHIER, enabled = true) }?.let { uRepo.save(it) }

            passwordEncoder.encode("chef")?.let { User(login = "chef", password = it, role = Role.ROLE_CHEF, enabled = true) }?.let { uRepo.save(it) }

            println("Users found with findAll():")
            println("-------------------------------")
            for (user in uRepo.findAll()) {
                println(user)
            }
            println("")
        }
    }

}

fun main(args: Array<String>) {
    runApplication<SmartKrabApplication>(*args)
}

