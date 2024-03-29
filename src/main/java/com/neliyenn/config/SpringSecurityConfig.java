package com.neliyenn.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * konfiguracja Spring Security
 * Wyłącza automatyczną konfigurację zabezpieczeń Spring Boot
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AccessDeniedHandler accessDeniedHandler;

    final DataSource dataSource;

    @Value("${spring.admin.username}")
    private String adminUsername;

    @Value("${spring.admin.username}")
    private String adminPassword;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;

    @Autowired
    public SpringSecurityConfig(AccessDeniedHandler accessDeniedHandler, DataSource dataSource) {
        this.accessDeniedHandler = accessDeniedHandler;
        this.dataSource = dataSource;
    }

    /**
     * konfiguracja HTTPSecurity
     * - rola ADMIN pozwala na dostep do /admin/**
     * - rola USER pozwala na dostęp do /user/** oraz /newPost/**
     * - kazdy moze odwiedzic /, /home, /about, /rejestracja, /error, /blog/**, /post/**, /h2-console/**
     * - pozostale strony wymagaja uwierzytelniania
     * - customowy 403 access denied handler
     */
   @Override
    protected void configure(HttpSecurity http) throws Exception {

       http.csrf().disable()
               .authorizeRequests()
               .antMatchers("/home", "/registration", "/error", "/blog/**", "/post/**", "/h2-console/**").permitAll()
               .antMatchers("/newPost/**", "/commentPost/**", "/createComment/**").hasAnyRole("USER")
               .anyRequest().authenticated()
               .and()
               .formLogin()
               .loginPage("/login")
               .defaultSuccessUrl("/home")
               .permitAll()
               .and()
               .logout()
               .permitAll()
               .and()
               .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
               .and().headers().frameOptions().disable();

   }

    /**
     * Detale uwierzytelniania
     */
   @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

       /**
        * uwierzytelnianie bazy danych
        */
       auth.
               jdbcAuthentication()
               .usersByUsernameQuery(usersQuery)
               .authoritiesByUsernameQuery(rolesQuery)
               .dataSource(dataSource)
               .passwordEncoder(passwordEncoder());

       /**
        * uwierzytelnianie w pamieci
        */
       auth.inMemoryAuthentication()
               .withUser(adminUsername).password(adminPassword).roles("ADMIN");

   }

    /**
     * Konfiguracja i "return" kodowania hasła BCrypt
     */

   @Bean
    public PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
   }


}
