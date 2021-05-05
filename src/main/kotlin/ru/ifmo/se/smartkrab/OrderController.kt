package ru.ifmo.se.smartkrab

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

import org.springframework.web.bind.annotation.PostMapping
import ru.ifmo.se.smartkrab.data.OrderInfo
import ru.ifmo.se.smartkrab.data.OrderRepository
import ru.ifmo.se.smartkrab.data.Position
import javax.validation.Valid


@Controller
class OrderController(val oRepo: OrderRepository) {

    @GetMapping("/new-order")
    fun extraCoinsForm(model: Model): String {
        model.addAttribute("order", OrderInfo())
        model.addAttribute("positions", listOf(
            Position(1, "Krabby Pattie"),
            Position(2, "Krusty Combo"),
            Position(3, "Krusty Deluxe"),
            Position(4, "SeaWeed Salad"),
            Position(5, "Coral Bits")
        ))
        return "new-order"
    }

    @PostMapping("/new-order")
    fun extraCoinsSubmit(@ModelAttribute("order") @Valid order: OrderInfo, bindingResult: BindingResult, model: Model): String {
        if (bindingResult.hasErrors()) {
            return "new-order"
        }

        model.addAttribute("order", order)

        oRepo.save(order)
        // fetch coins
        println("Orders found with findAll():")
        println("-------------------------------")
        for (e in oRepo.findAll()) {
            println(e.toString())
        }
        println("")

        return "new-order-submit"
    }
}