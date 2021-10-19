package ru.ifmo.se.smartkrab.service

import org.springframework.stereotype.Service
import org.springframework.ui.Model
import ru.ifmo.se.smartkrab.data.OrderInfo
import ru.ifmo.se.smartkrab.repository.OrderRepository
import ru.ifmo.se.smartkrab.data.Position

@Service
class OrderService(val oRepo: OrderRepository) {

    fun getOrder(model: Model): String {
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

    fun getExistingOrders(model: Model): String {
        model.addAttribute("order", OrderInfo())
        model.addAttribute("orders", oRepo.findAll())
        return "cooking"
    }

    fun addNewOrder(model: Model, order: OrderInfo): String {
        model.addAttribute("order", order)

        oRepo.save(order)

        println("Orders found with findAll():")
        println("-------------------------------")
        for (e in oRepo.findAll()) {
            println(e.toString())
        }
        println("")

        return "new-order-submit"
    }

    fun updateOrderStatus(model: Model, id: Long?, status: String): String {
        val orderInfo = oRepo.findById(id!!).get()
        orderInfo.status = status
        model.addAttribute("order", orderInfo)

        oRepo.save(orderInfo)

        println("Updated order:")
        println("-------------------------------")
        println(orderInfo)
        println("")

        return "cooking-submit"
    }
}
