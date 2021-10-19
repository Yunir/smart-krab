package ru.ifmo.se.smartkrab.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import ru.ifmo.se.smartkrab.data.Tool
import ru.ifmo.se.smartkrab.service.ToolService
import javax.validation.Valid

@Controller
class ToolController(val tService: ToolService) {

    @GetMapping("/new-tool")
    fun getTool(model: Model): String {
        return tService.getTool(model)
    }

    @GetMapping("/get-tool/{name}")
    fun getToolByName(@PathVariable name: String, model: Model): String {
        return tService.getToolByName(model, name)
    }

    @PostMapping("/new-tool")
    fun newToolSubmit(@ModelAttribute("tool") @Valid tool: Tool, bindingResult: BindingResult, model: Model): String {
        if (bindingResult.hasErrors()) {
            return "new-tool"
        }
        return tService.addNewTool(model, tool)
    }

    @DeleteMapping("/delete-tool/{name}")
    fun deleteTool(@PathVariable name: String): String {
        return tService.deleteTool(name)
    }

}