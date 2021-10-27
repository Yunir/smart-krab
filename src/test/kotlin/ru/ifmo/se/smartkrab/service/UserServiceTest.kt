package ru.ifmo.se.smartkrab.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.ui.ExtendedModelMap
import ru.ifmo.se.smartkrab.data.Role
import ru.ifmo.se.smartkrab.data.User
import ru.ifmo.se.smartkrab.repository.UserRepository

@ExtendWith(MockitoExtension::class)
class UserServiceTest {

    @InjectMocks
    lateinit var uService: UserService

    @Mock
    lateinit var uRepo: UserRepository

    @Test
    fun shouldAddNewUser() {
        val user = User("test", "test", Role.ROLE_CASHIER)

        uService.addNewUser(ExtendedModelMap(), user)

        Mockito.verify(uRepo).save(user)
    }

    @Test
    fun shouldNotAddExistingUser() {
        val user1 = User("test", "test", Role.ROLE_CASHIER)
        val user2 = User("test", "test", Role.ROLE_CASHIER)

        uService.addNewUser(ExtendedModelMap(), user1)
        uService.addNewUser(ExtendedModelMap(), user2)

        Mockito.verify(uRepo).save(user1)
        Mockito.verify(uRepo).save(user2)
    }

}