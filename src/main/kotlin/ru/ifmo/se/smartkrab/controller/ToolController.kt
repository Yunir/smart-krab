package ru.ifmo.se.smartkrab.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import ru.ifmo.se.smartkrab.data.Tool
import ru.ifmo.se.smartkrab.service.ToolService
import javax.validation.Valid

@Controller
class ToolController(val tService: ToolService) {

    @GetMapping("/get-tool/{name}")
    fun getTool(@PathVariable name: String, model: Model): String {
        return tService.getTool(model, name)
    }

    @PostMapping("/new-tool")
    fun newToolSubmit(@ModelAttribute("tool") @Valid tool: Tool, bindingResult: BindingResult, model: Model): String {
        if (bindingResult.hasErrors()) {
            return "add-new-tool"
        }
        return tService.addNewTool(model, tool)
    }

}