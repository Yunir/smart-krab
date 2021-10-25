package ru.ifmo.se.smartkrab.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class MvcConfig : WebMvcConfigurer {
    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/").setViewName("home")
        registry.addViewController("/new-user").setViewName("new-user")
        registry.addViewController("/sign-in").setViewName("sign-in")
        registry.addViewController("/extra-coins").setViewName("extra-coins")
        registry.addViewController("/daily-report").setViewName("daily-report")
        registry.addViewController("/new-order").setViewName("new-order")
        registry.addViewController("/cooking").setViewName("cooking")
        registry.addViewController("/new-tool").setViewName("new-tool")
        registry.addViewController("/delete-tool").setViewName("delete-tool")
        registry.addViewController("/antiplankton").setViewName("antiplankton")
        registry.addViewController("/access-denied").setViewName("access-denied")
    }
}