package ru.ifmo.se.smartkrab

fun printReportToCLI(reportName: String, elements: List<Any>) {
    println("$reportName report:")
    println("-------------------------------")
    println(elements.joinToString("\n"))
    println("")
}