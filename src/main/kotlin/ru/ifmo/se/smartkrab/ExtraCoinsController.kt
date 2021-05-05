package ru.ifmo.se.smartkrab

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

import org.springframework.web.bind.annotation.PostMapping
import ru.ifmo.se.smartkrab.data.ExtraCoins
import ru.ifmo.se.smartkrab.data.ExtraCoinsRepository
import javax.validation.Valid


@Controller
class ExtraCoinsController(val ecRepo: ExtraCoinsRepository) {

    @GetMapping("/extra-coins")
    fun extraCoinsForm(model: Model): String {
        model.addAttribute("extraCoins", ExtraCoins())
        return "extra-coins"
    }

    @PostMapping("/extra-coins")
    fun extraCoinsSubmit(@ModelAttribute @Valid extraCoins: ExtraCoins, bindingResult: BindingResult, model: Model): String {
        if (bindingResult.hasErrors()) {
            return "extra-coins"
        }

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