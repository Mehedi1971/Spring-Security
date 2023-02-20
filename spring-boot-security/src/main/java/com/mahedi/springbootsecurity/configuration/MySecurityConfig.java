package com.mahedi.springbootsecurity.configuration;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
//                .csrf().disable()
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
            .authorizeHttpRequests()
//                .requestMatchers ("/home","/register").permitAll()
//                .requestMatchers ("/public/**").permitAll()
                .requestMatchers ("/signing").permitAll()
                .requestMatchers ("/public/**").hasRole("USER")
                .requestMatchers ("/users/**").hasRole("ADMIN")
                .anyRequest()
            .authenticated()
            .and()
                .formLogin()
                .loginPage("/signing")
                .loginProcessingUrl("/dologin")
                .defaultSuccessUrl("/users/");
        return http.build();
    }

//    @Bean
//    public UserDetailsService users(){
//        UserDetails user= User.builder()
//                .username("mahedi")
//                .password(this.bCryptPasswordEncoder().encode("mahedi"))
//                .roles("USER")
//                .build();
//        UserDetails admin= User.builder()
//                .username("admin")
//                .password(this.bCryptPasswordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user,admin);
//    }

//@Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("Mahedi").password("1234").roles("NORMAL");
//        auth.inMemoryAuthentication().withUser("jhon").password("abc").roles("ADMIN");
//
//    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder(12);
    }

}
