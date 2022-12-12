package com.ticketapp.sfmoviehouse.config;

import com.ticketapp.sfmoviehouse.config.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;
    private final JwtRequestFilter jwtRequestFilter;

    @Autowired
    WebSecurityConfiguration(DataSource dataSource, JwtRequestFilter jwtRequestFilter) {
        this.dataSource = dataSource;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?")
                .authoritiesByUsernameQuery("SELECT username, authority FROM authorities AS a WHERE username=?");
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic()
                .and()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers(POST, "/users/signup").permitAll()
                .antMatchers(POST, "/authenticate").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").authenticated()
                .antMatchers(GET, "/public").permitAll()
                .antMatchers("/users/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/movies/**").hasRole("ADMIN")
                .antMatchers(GET,"/movies/**").hasRole("USER")
                .antMatchers("/tickets/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/files/**").hasRole("ADMIN")
                .anyRequest().denyAll()
                .and()
                .csrf().disable()
                .formLogin().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }
}