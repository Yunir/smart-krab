package ru.ifmo.se.smartkrab.access

import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext


@SpringBootTest
class RoleBasedAccessTest() {

    @Autowired lateinit var context: WebApplicationContext
    lateinit var mvc: MockMvc

    @BeforeEach
    fun setUp() {
        mvc = MockMvcBuilders
            .webAppContextSetup(this.context)
            .apply<DefaultMockMvcBuilder>(springSecurity())
            .build()
    }

    @Test
    @WithMockUser(username="krusty", roles = arrayOf("OWNER"))
    fun ownerHasAccessToNewUserPage() {
        mvc.perform(get("/new-user"))
            .andExpect(content().string(containsString("User role:")))
    }

    @Test
    @WithMockUser(username="sponge", roles = arrayOf("CHEF"))
    fun chefDenyAccessToNewUserPage() {
        mvc.perform(get("/new-user"))
            .andExpect(status().is4xxClientError)
    }

    @Test
    @WithMockUser(username="squid", roles = arrayOf("CASHIER"))
    fun cashierDenyAccessToNewUserPage() {
        mvc.perform(get("/new-user"))
            .andExpect(status().is4xxClientError)
    }

    @Test
    @WithMockUser(username="krusty", roles = arrayOf("OWNER"))
    fun ownerHasAccessToExtraCoinsPage() {
        mvc.perform(get("/extra-coins"))
            .andExpect(content().string(containsString("Extra coins value")))
    }

    @Test
    @WithMockUser(username="sponge", roles = arrayOf("CHEF"))
    fun chefDenyAccessToExtraCoinsPage() {
        mvc.perform(get("/extra-coins"))
            .andExpect(status().is4xxClientError)
    }

    @Test
    @WithMockUser(username="squid", roles = arrayOf("CASHIER"))
    fun cashierDenyAccessToExtraCoinsPage() {
        mvc.perform(get("/extra-coins"))
            .andExpect(status().is4xxClientError)
    }

    @Test
    @WithMockUser(username="krusty", roles = arrayOf("OWNER"))
    fun ownerHasAccessToDailyReportPage() {
        mvc.perform(get("/daily-report"))
            .andExpect(content().string(containsString("Position")))
    }

    @Test
    @WithMockUser(username="sponge", roles = arrayOf("CHEF"))
    fun chefDenyAccessToDailyReportPage() {
        mvc.perform(get("/daily-report"))
            .andExpect(status().is4xxClientError)
    }

    @Test
    @WithMockUser(username="squid", roles = arrayOf("CASHIER"))
    fun cashierHasAccessToDailyReportPage() {
        mvc.perform(get("/daily-report"))
            .andExpect(content().string(containsString("Position")))
    }

    @Test
    @WithMockUser(username="krusty", roles = arrayOf("OWNER"))
    fun ownerDenyAccessToNewOrderPage() {
        mvc.perform(get("/new-order"))
            .andExpect(status().is4xxClientError)
    }

    @Test
    @WithMockUser(username="sponge", roles = arrayOf("CHEF"))
    fun chefDenyAccessToNewOrderPage() {
        mvc.perform(get("/new-order"))
            .andExpect(status().is4xxClientError)
    }

    @Test
    @WithMockUser(username="squid", roles = arrayOf("CASHIER"))
    fun cashierHasAccessToNewOrderPage() {
        mvc.perform(get("/new-order"))
            .andExpect(content().string(containsString("Register new order")))
    }

    @Test
    @WithMockUser(username="krusty", roles = arrayOf("OWNER"))
    fun ownerDenyAccessToCookingPage() {
        mvc.perform(get("/cooking"))
            .andExpect(status().is4xxClientError)
    }

    @Test
    @WithMockUser(username="sponge", roles = arrayOf("CHEF"))
    fun chefHasAccessToCookingPage() {
        mvc.perform(get("/cooking"))
            .andExpect(content().string(containsString("Order status:")))
    }

    @Test
    @WithMockUser(username="squid", roles = arrayOf("CASHIER"))
    fun cashierDenyAccessToCookingPage() {
        mvc.perform(get("/cooking"))
            .andExpect(status().is4xxClientError)
    }

    @Test
    @WithMockUser(username="krusty", roles = arrayOf("OWNER"))
    fun ownerDenyAccessToNewToolPage() {
        mvc.perform(get("/new-tool"))
            .andExpect(status().is4xxClientError)
    }

    @Test
    @WithMockUser(username="sponge", roles = arrayOf("CHEF"))
    fun chefHasAccessToNewToolPage() {
        mvc.perform(get("/new-tool"))
            .andExpect(content().string(containsString("Tool name:")))
    }

    @Test
    @WithMockUser(username="squid", roles = arrayOf("CASHIER"))
    fun cashierDenyAccessToNewToolPage() {
        mvc.perform(get("/new-tool"))
            .andExpect(status().is4xxClientError)
    }

    @Test
    @WithMockUser(username="krusty", roles = arrayOf("OWNER"))
    fun ownerDenyAccessToDeleteToolPage() {
        mvc.perform(get("/delete-tool"))
            .andExpect(status().is4xxClientError)
    }

    @Test
    @WithMockUser(username="sponge", roles = arrayOf("CHEF"))
    fun chefHasAccessToDeleteToolPage() {
        mvc.perform(get("/delete-tool"))
            .andExpect(content().string(containsString("Tool name:")))
    }

    @Test
    @WithMockUser(username="squid", roles = arrayOf("CASHIER"))
    fun cashierDenyAccessToDeleteToolPage() {
        mvc.perform(get("/delete-tool"))
            .andExpect(status().is4xxClientError)
    }

    @Test
    @WithMockUser(username="krusty", roles = arrayOf("OWNER"))
    fun ownerHasAccessToAntiPlanktonPage() {
        mvc.perform(get("/antiplankton"))
            .andExpect(content().string(containsString("Current status:")))
    }

    @Test
    @WithMockUser(username="sponge", roles = arrayOf("CHEF"))
    fun chefDenyAccessToAntiPlanktonPage() {
        mvc.perform(get("/antiplankton"))
            .andExpect(status().is4xxClientError)
    }

    @Test
    @WithMockUser(username="squid", roles = arrayOf("CASHIER"))
    fun cashierHasAccessToAntiPlanktonPage() {
        mvc.perform(get("/antiplankton"))
            .andExpect(content().string(containsString("Current status:")))
    }
}