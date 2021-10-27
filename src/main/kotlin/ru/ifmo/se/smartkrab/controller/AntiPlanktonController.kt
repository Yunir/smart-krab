package ru.ifmo.se.smartkrab.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

import org.springframework.web.bind.annotation.PostMapping
import ru.ifmo.se.smartkrab.data.AntiPlanktonStatus
import ru.ifmo.se.smartkrab.data.ExtraCoins
import ru.ifmo.se.smartkrab.service.AntiPlanktonService
import ru.ifmo.se.smartkrab.service.ExtraCoinsService
import javax.validation.Valid

@Controller
class AntiPlanktonController(val apService: AntiPlanktonService) {

    @GetMapping("/antiplankton")
    fun extraCoinsForm(model: Model): String {
        return apService.getAntiPlanktonStatus(model)
    }

    @PostMapping("/antiplankton")
    fun extraCoinsSubmit(@ModelAttribute @Valid antiplankton: AntiPlanktonStatus, bindingResult: BindingResult, model: Model): String {
        return apService.changeAntiPlanktonStatus(antiplankton, model)
    }
}