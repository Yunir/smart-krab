package ru.ifmo.se.smartkrab.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.ui.Model
import ru.ifmo.se.smartkrab.data.AntiPlanktonStatus
import ru.ifmo.se.smartkrab.data.ExtraCoins
import ru.ifmo.se.smartkrab.printReportToCLI
import ru.ifmo.se.smartkrab.repository.AntiPlanktonRepository
import ru.ifmo.se.smartkrab.repository.ExtraCoinsRepository

@Service
class AntiPlanktonService(val apRepository: AntiPlanktonRepository) {

    fun getAntiPlanktonStatus(model: Model): String {
        model.addAttribute("antiplankton", apRepository.findById(1).get())
        return "antiplankton"
    }

    fun changeAntiPlanktonStatus(antiplankton: AntiPlanktonStatus, model: Model): String {
        val a = apRepository.findById(1).get()

        a.status = !(a.status)!!
        apRepository.save(a)
        model.addAttribute("antiplankton", a)
        return "antiplankton"
    }
}
