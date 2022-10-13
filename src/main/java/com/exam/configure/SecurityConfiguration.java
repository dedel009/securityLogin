package com.exam.configure;

import com.exam.service.AdminDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/qazx").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/qazx")
                .loginProcessingUrl("/loginProcess")
                .usernameParameter("adminId")
                .passwordParameter("password")
                .failureUrl("/qazx?error=true")
                .defaultSuccessUrl("/")
                .and()
                .logout().permitAll()
                .logoutUrl("/qazx/logout")
                .logoutSuccessUrl("/qazx");

        http.csrf().disable();
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/css/**","/js/**","/img/**","/h2-console/**");
    }

}
