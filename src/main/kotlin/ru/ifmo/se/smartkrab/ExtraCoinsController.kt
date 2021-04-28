package ru.ifmo.se.smartkrab

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

import org.springframework.web.bind.annotation.PostMapping
import ru.ifmo.se.smartkrab.data.ExtraCoins
import ru.ifmo.se.smartkrab.data.ExtraCoinsRepository


@Controller
class ExtraCoinsController(val ecRepo: ExtraCoinsRepository) {

    @GetMapping("/extra-coins")
    fun extraCoinsForm(model: Model): String {
        model.addAttribute("extraCoins", ExtraCoins())
        return "extra-coins"
    }

    @PostMapping("/extra-coins")
    fun extraCoinsSubmit(@ModelAttribute extraCoins: ExtraCoins, model: Model): String {
        model.addAttribute("extraCoins", extraCoins)

        ecRepo.save(extraCoins)
        // fetch coins
        println("ExtraCoins found with findAll():")
        println("-------------------------------")
        for (e in ecRepo.findAll()) {
            println(e.toString())
        }
        println("")

        return "extra-coins-submit"
    }
}

class Greeting {
    var id: Long = 0
    var content: String? = null
}