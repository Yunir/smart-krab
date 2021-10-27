package ru.ifmo.se.smartkrab.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import ru.ifmo.se.smartkrab.service.DailyReportService

@Controller
class DailyReportController(val drService: DailyReportService) {

    @GetMapping("/daily-report")
    fun newOrderForm(model: Model): String {
        return drService.getDailyReport(model)
    }
}