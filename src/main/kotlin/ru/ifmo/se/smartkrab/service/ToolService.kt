package ru.ifmo.se.smartkrab.service

import org.springframework.stereotype.Service
import org.springframework.ui.Model
import ru.ifmo.se.smartkrab.data.Tool
import ru.ifmo.se.smartkrab.repository.ToolRepository

@Service
class ToolService(val tRepo: ToolRepository) {

    fun getTool(model: Model, name: String): String {
        val tool = tRepo.findByName(name)
        model.addAttribute("tool", tool)

        println("Found tool:")
        println("-------------------------------")
        println(tool)
        println("")

        return "tools-status"
    }

    fun addNewTool(model: Model, tool: Tool): String {
        model.addAttribute("tool", tool)

        tRepo.save(tool)

        println("Tools found with findAll():")
        println("-------------------------------")
        for (e in tRepo.findAll()) {
            println(e.toString())
        }
        println("")

        return "add-new-tool-submit"
    }

}