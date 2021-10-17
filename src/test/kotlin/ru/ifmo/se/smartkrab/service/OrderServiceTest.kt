package ru.ifmo.se.smartkrab.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.eq
import org.springframework.ui.ExtendedModelMap
import ru.ifmo.se.smartkrab.data.OrderInfo
import ru.ifmo.se.smartkrab.repository.OrderRepository
import java.util.*

@ExtendWith(MockitoExtension::class)
class OrderServiceTest {

    private val ORDER_ID = 1L
    private val ORDER_UPDATED_STATUS = "inProgress"

    @InjectMocks
    lateinit var oService: OrderService

    @Mock
    lateinit var oRepo: OrderRepository

    @Test
    fun shouldAddNewOrder() {
        val order = OrderInfo()

        oService.addNewOrder(ExtendedModelMap(), order)

        Mockito.verify(oRepo).save(order)
    }

    @Test
    fun shouldUpdateOrderStatus() {
        val order = OrderInfo(id = ORDER_ID)
        Mockito.`when`(oRepo.findById(eq(ORDER_ID)))
                .thenReturn(Optional.of(order))

        oService.updateOrderStatus(ExtendedModelMap(), ORDER_ID, ORDER_UPDATED_STATUS)

        Mockito.verify(oRepo).findById(ORDER_ID)
        Mockito.verify(oRepo).save(order)
    }
}