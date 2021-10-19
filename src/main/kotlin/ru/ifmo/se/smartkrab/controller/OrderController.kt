package ru.ifmo.se.smartkrab.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

import ru.ifmo.se.smartkrab.data.OrderInfo
import ru.ifmo.se.smartkrab.service.OrderService
import javax.validation.Valid

@Controller
class OrderController(val oService: OrderService) {

    @GetMapping("/new-order")
    fun newOrderForm(model: Model): String {
        return oService.getOrder(model)
    }

    @GetMapping("/cooking")
    fun getExistingOrders(model: Model): String {
        return oService.getExistingOrders(model)
    }

    @PostMapping("/new-order")
    fun newOrderSubmit(@ModelAttribute("order") @Valid order: OrderInfo, bindingResult: BindingResult, model: Model): String {
        if (bindingResult.hasErrors()) {
            return "new-order"
        }
        return oService.addNewOrder(model, order)
    }

    @PutMapping("/order-status")
    fun updateOrderStatus(@ModelAttribute("order") order: OrderInfo, model: Model): String {
        return oService.updateOrderStatus(model, order.id, order.status)
    }
}