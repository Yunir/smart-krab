package ru.ifmo.se.smartkrab.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

import org.springframework.web.bind.annotation.PostMapping
import ru.ifmo.se.smartkrab.data.ExtraCoins
import ru.ifmo.se.smartkrab.service.ExtraCoinsService
import javax.validation.Valid

@Controller
class ExtraCoinsController(val ecService: ExtraCoinsService) {

    @GetMapping("/extra-coins")
    fun extraCoinsForm(model: Model): String {
        return ecService.getExtraCoins(model)
    }

    @PostMapping("/extra-coins")
    fun extraCoinsSubmit(@ModelAttribute @Valid extraCoins: ExtraCoins, bindingResult: BindingResult, model: Model): String {
        if (bindingResult.hasErrors()) {
            return "extra-coins"
        }
        return ecService.saveExtraCoins(extraCoins, model)
    }
}