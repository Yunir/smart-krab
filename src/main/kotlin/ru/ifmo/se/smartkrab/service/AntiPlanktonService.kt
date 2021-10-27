package ru.ifmo.se.smartkrab.service

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.ui.Model
import ru.ifmo.se.smartkrab.data.AntiPlanktonStatus
import ru.ifmo.se.smartkrab.repository.AntiPlanktonRepository


@Service
class AntiPlanktonService(val apRepository: AntiPlanktonRepository) {

    fun getAntiPlanktonStatus(model: Model): String {
        model.addAttribute("antiplankton", apRepository.findById(1).get())
        return "antiplankton"
    }

    fun changeAntiPlanktonStatus(antiplankton: AntiPlanktonStatus, model: Model): String {
        val a = apRepository.findById(1).get()

        val isOwner = SecurityContextHolder.getContext().authentication.authorities.stream().findFirst().get().toString() == "ROLE_OWNER"
        if (a.status == true && isOwner) {
            a.status = !(a.status)!!
        } else if (a.status == false) {
            a.status = !(a.status)!!
        }
        apRepository.save(a)
        model.addAttribute("antiplankton", a)
        return "antiplankton"
    }
}
