package ru.ifmo.se.smartkrab.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import javax.sql.DataSource


@Configuration
@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        if (http != null) {
            http.authorizeRequests()
                .antMatchers("/", "/css/**", "/img/**", "/js/**", "/get-tool/**").permitAll()
                .antMatchers("/antiplankton", "/daily-report").hasAnyRole("OWNER", "CASHIER")
                .antMatchers("/new-user", "/extra-coins").hasRole("OWNER")
                .antMatchers("/new-order").hasRole("CASHIER")
                .antMatchers("/order-status", "/new-tool", "/delete-tool", "/cooking").hasRole("CHEF")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/sign-in").permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied")
        }
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }

    @Autowired
    private val dataSource: DataSource? = null

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.jdbcAuthentication().dataSource(dataSource)
            .passwordEncoder(passwordEncoder())
            .usersByUsernameQuery("select login,password,enabled from krab_user where login=?")
            .authoritiesByUsernameQuery("select login, role from krab_user where login=?")
    }
}