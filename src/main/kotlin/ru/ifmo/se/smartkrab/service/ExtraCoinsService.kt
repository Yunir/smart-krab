package ru.ifmo.se.smartkrab.service

import org.springframework.stereotype.Service
import org.springframework.ui.Model
import ru.ifmo.se.smartkrab.data.ExtraCoins
import ru.ifmo.se.smartkrab.repository.ExtraCoinsRepository

@Service
class ExtraCoinsService(val ecRepo: ExtraCoinsRepository) {

    fun getExtraCoins(model: Model): String {
        model.addAttribute("extraCoins", ExtraCoins())
        return "extra-coins"
    }

    fun saveExtraCoins(extraCoins: ExtraCoins, model: Model): String {
        model.addAttribute("extraCoins", extraCoins)

        ecRepo.save(extraCoins)

        println("ExtraCoins found with findAll():")
        println("-------------------------------")
        for (e in ecRepo.findAll()) {
            println(e.toString())
        }
        println("")

        return "extra-coins-submit"
    }

}
