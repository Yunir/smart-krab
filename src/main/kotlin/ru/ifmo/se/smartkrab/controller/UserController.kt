package ru.ifmo.se.smartkrab.controller;

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import ru.ifmo.se.smartkrab.data.User
import ru.ifmo.se.smartkrab.service.UserService
import javax.validation.Valid

@Controller
class UserController(val uService: UserService) {


    @GetMapping("/new-user")
    fun extraCoinsForm(model: Model): String {
        return uService.getUser(model)
    }

    @PostMapping("/new-user")
    fun newUserSubmit(@ModelAttribute("user") @Valid user: User, bindingResult: BindingResult, model: Model): String {
        if (bindingResult.hasErrors()) {
            return "new-user"
        }
        return uService.addNewUser(model, user)
    }
}
