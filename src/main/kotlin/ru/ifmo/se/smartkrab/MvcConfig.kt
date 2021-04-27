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
    }
}