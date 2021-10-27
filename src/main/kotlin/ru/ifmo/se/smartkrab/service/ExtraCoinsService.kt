package ru.ifmo.se.smartkrab.service

import org.springframework.stereotype.Service
import org.springframework.ui.Model
import ru.ifmo.se.smartkrab.data.ExtraCoins
import ru.ifmo.se.smartkrab.printReportToCLI
import ru.ifmo.se.smartkrab.repository.ExtraCoinsRepository

@Service
class ExtraCoinsService(val ecRepo: ExtraCoinsRepository) {

    fun getExtraCoins(model: Model): String {
        model.addAttribute("extraCoins", ExtraCoins())
        return "extra-coins"
    }

    fun saveExtraCoins(extraCoins: ExtraCoins, model: Model): String {
        model.addAttribute("extraCoins", extraCoins)

        ecRepo.save(extraCoins)

        printReportToCLI("ExtraCoins", ecRepo.findAll().toList())

        return "extra-coins-submit"
    }

}
