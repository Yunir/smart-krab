package ru.ifmo.se.smartkrab.service

import org.springframework.stereotype.Service
import org.springframework.ui.Model
import ru.ifmo.se.smartkrab.data.Tool
import ru.ifmo.se.smartkrab.printReportToCLI
import ru.ifmo.se.smartkrab.repository.ToolRepository

@Service
class ToolService(val tRepo: ToolRepository) {

    fun getTool(model: Model): String {
        model.addAttribute("tool", Tool(""))
        return "new-tool"
    }

    fun getToolByName(model: Model, name: String): String {
        val tool = tRepo.findByName(name)
        model.addAttribute("tool", tool)

        printReportToCLI("Tool found by name", listOfNotNull(tool))

        return "delete-tool"
    }

    fun addNewTool(model: Model, tool: Tool): String {
        model.addAttribute("tool", tool)

        tRepo.save(tool)

        printReportToCLI("Tools", tRepo.findAll().toList())

        return "new-tool-submit"
    }

    fun getExistingTools(model: Model): String {
        model.addAttribute("tool", Tool(name = ""))
        model.addAttribute("tools", tRepo.findAll())
        return "delete-tool"
    }

    fun deleteTool(name: String): String {
        val tool = tRepo.findByName(name)
        if (tool != null) {
            tRepo.delete(tool)
            printReportToCLI("Tool deleted", listOfNotNull(tool))
            printReportToCLI("Tools", tRepo.findAll().toList())
        }

        return "delete-tool-submit"
    }

}