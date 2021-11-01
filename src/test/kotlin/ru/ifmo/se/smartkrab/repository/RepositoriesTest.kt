package ru.ifmo.se.smartkrab.repository

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import ru.ifmo.se.smartkrab.data.*
import javax.validation.ConstraintViolationException

@DataJpaTest
class RepositoriesTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val antiPlanktonRepository: AntiPlanktonRepository,
    val extraCoinsRepository: ExtraCoinsRepository,
    val orderRepository: OrderRepository,
    val toolRepository: ToolRepository,
    val userRepository: UserRepository
) {

    @Test
    fun antiPlanktonFindReturnSingleStatus() {
        val status = AntiPlanktonStatus()
        entityManager.persist(status)
        entityManager.flush()
        assert(antiPlanktonRepository.findAll().count() == 1)
    }

    @Test
    fun antiPlanktonInitialStatusIsFalse() {
        val status = AntiPlanktonStatus()
        entityManager.persist(status)
        entityManager.flush()
        assert(antiPlanktonRepository.findById(1).get().status == false)
    }

    @Test
    fun extraCoinsFindByAddedAt() {
        val extraCoins = ExtraCoins(5)
        entityManager.persist(extraCoins)
        entityManager.flush()
        assert(extraCoinsRepository.findByAddedAt(extraCoins.addedAt).count() == 1)
    }

    @Test
    fun orderRepositoryViolateLowerBoundary() {
        val order = OrderInfo(value = 0)
        assertThatThrownBy { entityManager.persist(order) }
            .isInstanceOf(ConstraintViolationException::class.java).hasMessageContaining("should be greater than 1")
    }

    @Test
    fun orderRepositoryViolateUpperBoundary() {
        val order = OrderInfo(value = 11)
        assertThatThrownBy { entityManager.persist(order) }
            .isInstanceOf(ConstraintViolationException::class.java).hasMessageContaining("should be less than or equals to 10")
    }

    @Test
    fun orderRepositoryFindAllOrders() {
        val order1 = OrderInfo()
        val order2 = OrderInfo()
        val order3 = OrderInfo()
        entityManager.persist(order1)
        entityManager.persist(order2)
        entityManager.persist(order3)
        entityManager.flush()
        assert(orderRepository.findAll().count() == 3)
    }

    @Test
    fun toolRepositoryFindToolByName() {
        val name = "Metal stick"
        val tool = Tool(name)
        entityManager.persist(tool)
        entityManager.flush()
        assert(toolRepository.findByName(name) is Tool)
    }

    @Test
    fun toolRepositoryFindBadToolByName() {
        val name = "Metal stick"
        val name2 = "Another metal stick"
        val tool = Tool(name)
        entityManager.persist(tool)
        entityManager.flush()
        assert(toolRepository.findByName(name2) == null)
    }

    @Test
    fun userRepositoryFindToolByName() {
        val login = "pearl"
        val user = User(login, "12345", Role.ROLE_OWNER)
        entityManager.persist(user)
        entityManager.flush()
        assert(userRepository.findByLogin(login) is User)
    }
}