package com.exam.configure;

import com.exam.service.AdminDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.RequestCacheConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
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
    public SecurityFilterChain resources(HttpSecurity http) throws Exception {
        return http.requestMatchers(matchers -> matchers
                        .antMatchers("/static/**"))
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll())
                .requestCache(RequestCacheConfigurer::disable)
                .securityContext(AbstractHttpConfigurer::disable)
                .sessionManagement(AbstractHttpConfigurer::disable)
                .build();
    }

    @Bean
    public SecurityFilterChain adminFilterChain(HttpSecurity http) throws Exception {

//        http
//                .authenticationProvider(adminAuthenticationProvider())
//                .antMatcher("/admin/**")
//                .authorizeHttpRequests().anyRequest().hasAnyAuthority("ROLE_ADMIN")
//                .and()
//                .formLogin()
//                .loginPage("/admin/login")
//                .loginProcessingUrl("/admin/login")
//                .failureUrl("/admin/login?error=true")
//                .defaultSuccessUrl("/admin")
//                .permitAll()
//                .and()
//                .logout().logoutUrl("/admin/logout")
//                .logoutSuccessUrl("/admin")
//                .and().csrf().disable();

        http
                .authenticationProvider(adminAuthenticationProvider())
                .antMatcher("/admin/**")
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest()
                        .hasAnyAuthority("ROLE_ADMIN"))
                .formLogin(form -> form
                        .loginPage("/admin/login")
                        .loginProcessingUrl("/admin/login")
                        .failureUrl("/admin/login?error=true")
                        .defaultSuccessUrl("/admin")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/admin/logout")
                        .logoutSuccessUrl("/admin"))
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }



}
