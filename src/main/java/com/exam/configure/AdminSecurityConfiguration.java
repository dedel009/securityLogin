package com.exam.configure;

import com.exam.service.AdminDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Order(1)
public class AdminSecurityConfiguration {

    @Bean
    public UserDetailsService adminDetailsService(){
        return new AdminDetailService();
    }

    @Bean
    public PasswordEncoder adminPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider adminAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(adminDetailsService());
        provider.setPasswordEncoder(adminPasswordEncoder());

        return provider;
    }

    @Bean
    public SecurityFilterChain adminFilterChain(HttpSecurity http) throws Exception {
        http
                .authenticationProvider(adminAuthenticationProvider())
                .authorizeHttpRequests()
                .antMatchers("/admin/**")
                .hasAnyAuthority("ROLE_ADMIN")
                .and()
                .formLogin()
                .loginPage("/admin/login")
                .loginProcessingUrl("/admin/login")
                .failureUrl("/admin/login?error=true")
                .defaultSuccessUrl("/admin")
                .permitAll()
                .and()
                .logout().logoutUrl("/admin/logout")
                .logoutSuccessUrl("/admin")
                .and().csrf().disable();

        return http.build();
    }



}
