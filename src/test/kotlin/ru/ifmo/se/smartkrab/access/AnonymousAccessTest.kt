package ru.ifmo.se.smartkrab.access

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AnonymousAccessTest(@Autowired val template: TestRestTemplate) {

    @Test
    fun accessToHomePage() {
        val entity = template.getForEntity<String>("/")
        assertThat(entity.body).contains("Welcome to Smart Krab")
    }

    @Test
    fun accessToSignInPage() {
        val entity = template.getForEntity<String>("/sign-in")
        assertThat(entity.body).contains("Sign-in to your SmartKrab")
    }

    @ParameterizedTest(name = "{index}: redirect {0} to sign-in page")
    @ValueSource(strings = arrayOf(
        "new-user",
        "extra-coins",
        "daily-report",
        "new-order",
        "cooking",
        "new-tool",
        "delete-tool",
        "antiplankton",
        "access-denied"
    ))
    fun redirectOtherPagesToSignInPage(page: String) {
            assertThat(template.getForEntity<String>("/$page").body)
                .contains("Sign-in to your SmartKrab")
    }
}