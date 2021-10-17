package ru.ifmo.se.smartkrab.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.eq
import org.springframework.ui.ExtendedModelMap
import ru.ifmo.se.smartkrab.data.Tool
import ru.ifmo.se.smartkrab.repository.ToolRepository

@ExtendWith(MockitoExtension::class)
class ToolServiceTest {

    private val TOOL_NAME = "testToolName"

    @InjectMocks
    lateinit var tService: ToolService

    @Mock
    lateinit var tRepo: ToolRepository

    @Test
    fun shouldGetTool() {
        val tool = Tool(TOOL_NAME)
        Mockito.`when`(tRepo.findByName(eq(TOOL_NAME)))
                .thenReturn(tool)

        tService.getTool(ExtendedModelMap(), TOOL_NAME)

        Mockito.verify(tRepo).findByName(TOOL_NAME)
    }

    @Test
    fun shouldAddNewTool() {
        val tool = Tool(TOOL_NAME)

        tService.addNewTool(ExtendedModelMap(), tool)

        Mockito.verify(tRepo).save(tool)
    }

    @Test
    fun shouldDeleteTool() {
        val tool = Tool(TOOL_NAME)
        Mockito.`when`(tRepo.findByName(eq(TOOL_NAME)))
                .thenReturn(tool)

        tService.deleteTool(TOOL_NAME)

        Mockito.verify(tRepo).findByName(TOOL_NAME)
        Mockito.verify(tRepo).delete(tool)
    }
}