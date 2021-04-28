package ru.ifmo.se.smartkrab

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

import org.springframework.web.bind.annotation.PostMapping
import ru.ifmo.se.smartkrab.data.OrderInfo
import ru.ifmo.se.smartkrab.data.OrderRepository


@Controller
class OrderController(val oRepo: OrderRepository) {

    @GetMapping("/new-order")
    fun extraCoinsForm(model: Model): String {
        model.addAttribute("order", OrderInfo())
        return "new-order"
    }

    @PostMapping("/new-order")
    fun extraCoinsSubmit(@ModelAttribute order: OrderInfo, model: Model): String {
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