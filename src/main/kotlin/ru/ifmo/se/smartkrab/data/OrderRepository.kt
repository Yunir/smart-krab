package ru.ifmo.se.smartkrab.data

import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<OrderInfo, Long> {

}