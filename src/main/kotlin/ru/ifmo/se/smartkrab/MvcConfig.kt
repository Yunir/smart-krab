package ru.ifmo.se.smartkrab

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class MvcConfig: WebMvcConfigurer {
    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/").setViewName("home")
        registry.addViewController("/add-user").setViewName("add-user")
        registry.addViewController("/sign-in").setViewName("sign-in")
        registry.addViewController("/extra-coins").setViewName("extra-coins")
        registry.addViewController("/daily-report").setViewName("daily-report")
        registry.addViewController("/new-order").setViewName("new-order")
        registry.addViewController("/cooking").setViewName("cooking")
        registry.addViewController("/add-new-tool").setViewName("add-new-tool")
        registry.addViewController("/tools-status").setViewName("tools-status")
        registry.addViewController("/antiplankton").setViewName("antiplankton")
    }
}