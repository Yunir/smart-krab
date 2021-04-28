package ru.ifmo.se.smartkrab

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import ru.ifmo.se.smartkrab.data.ExtraCoins
import ru.ifmo.se.smartkrab.data.ExtraCoinsRepository
import ru.ifmo.se.smartkrab.data.OrderInfo
import ru.ifmo.se.smartkrab.data.OrderRepository


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
            // save some coins
            oRepo.save(OrderInfo(value = 5))

            // fetch coins
            println("Orders found with findAll():")
            println("-------------------------------")
            for (extraCoins in oRepo.findAll()) {
                println(extraCoins.toString())
            }
            println("")
        }
    }
}

fun main(args: Array<String>) {
    runApplication<SmartKrabApplication>(*args)
}

