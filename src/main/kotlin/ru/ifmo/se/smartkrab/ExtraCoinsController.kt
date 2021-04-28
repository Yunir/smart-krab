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
        model.addAttribute("greeting", Greeting())
        return "extra-coins"
    }

    @PostMapping("/extra-coins")
    fun extraCoinsSubmit(@ModelAttribute greeting: Greeting, model: Model): String {
        model.addAttribute("greeting", greeting)

        ecRepo.save(ExtraCoins(greeting.id.toInt()))
        // fetch coins
        println("ExtraCoins found with findAll():")
        println("-------------------------------")
        for (extraCoins in ecRepo.findAll()) {
            println(extraCoins.toString())
        }
        println("")

        return "extra-coins-submit"
    }
}

class Greeting {
    var id: Long = 0
    var content: String? = null
}