package ru.ifmo.se.smartkrab.service

import org.springframework.stereotype.Service
import org.springframework.ui.Model
import ru.ifmo.se.smartkrab.repository.ExtraCoinsRepository
import ru.ifmo.se.smartkrab.repository.OrderRepository

@Service
class DailyReportService(val oRepo: OrderRepository, val ecRepo: ExtraCoinsRepository) {
    fun getDailyReport(model: Model): String {
        val orders = oRepo.findAll()
        val extraCoins = ecRepo.findAll()
        model.addAttribute("orders", orders)
        model.addAttribute("extraCoins", extraCoins)
        return "daily-report"
    }
}