package ru.ifmo.se.smartkrab.service

import org.springframework.stereotype.Service
import org.springframework.ui.Model
import ru.ifmo.se.smartkrab.data.Tool
import ru.ifmo.se.smartkrab.repository.ToolRepository

@Service
class ToolService(val tRepo: ToolRepository) {

    fun addNewTool(model: Model, tool: Tool): String {
        model.addAttribute("tool", tool)

        tRepo.save(tool)
        // fetch coins
        println("Tools found with findAll():")
        println("-------------------------------")
        for (e in tRepo.findAll()) {
            println(e.toString())
        }
        println("")

        return "add-new-tool-submit"
    }

}