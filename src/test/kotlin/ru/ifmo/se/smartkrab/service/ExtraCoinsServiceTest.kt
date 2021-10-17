package ru.ifmo.se.smartkrab.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.ui.ExtendedModelMap
import ru.ifmo.se.smartkrab.data.ExtraCoins
import ru.ifmo.se.smartkrab.repository.ExtraCoinsRepository

@ExtendWith(MockitoExtension::class)
class ExtraCoinsServiceTest {

    @InjectMocks
    lateinit var ecService: ExtraCoinsService

    @Mock
    lateinit var ecRepo: ExtraCoinsRepository

    @Test
    fun shouldSaveExtraCoins() {
        val extraCoins = ExtraCoins()

        ecService.saveExtraCoins(extraCoins, ExtendedModelMap())

        Mockito.verify(ecRepo).save(extraCoins)
    }

}