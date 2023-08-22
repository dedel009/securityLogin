package com.exam.configure;

import com.exam.configure.handler.UserFailureHandler;
import com.exam.service.UserDetailService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@Order(2)
public class UserSecurityConfiguration {

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailService();
    }

    @Bean
    public PasswordEncoder userPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationFailureHandler userFailureHandler() { return new UserFailureHandler();}

    @Bean
    public DaoAuthenticationProvider userAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(userPasswordEncoder());

        return provider;
    }

    @Bean
    public SecurityFilterChain userFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authenticationProvider(userAuthenticationProvider())
//                .antMatcher("/**")
//                .authorizeHttpRequests()
//                .antMatchers("/")
//                .permitAll()
//                .anyRequest()
//                .hasAnyAuthority("ROLE_USER")
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/login")
//                .failureUrl("/login?error=true")
//                .defaultSuccessUrl("/")
//                .permitAll()
//                .and().logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/")
//                .and()
//                .csrf().disable();

        http
                .authenticationProvider(userAuthenticationProvider())
                .antMatcher("/**")
                .authorizeHttpRequests(authorize -> authorize
                        .antMatchers("/article/*/*").hasAnyAuthority("ROLE_USER")
                        .anyRequest().permitAll())
                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .failureUrl("/login?error=true")
                        .failureHandler(userFailureHandler())
                        .defaultSuccessUrl("/")
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/"))
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/h2-console/**");
    }
}
