package com.app.jpa.security.jpa.security;

import com.app.jpa.security.jpa.entity.User;
import com.app.jpa.security.jpa.service.UserService;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;
    private UserService userService;

    public SecurityConfigurer(UserService userService){
        this.userService = userService;
        userDetailsService = (userName)->{
            User dbUser = userService.findUserByName(userName);
            if(dbUser == null){
                throw new UsernameNotFoundException("User '"+ userName+"' not found.");
            }
            return new org.springframework.security.core.userdetails.User(dbUser.getName(),dbUser.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_"+dbUser.getRole())));
        };
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/role").hasAnyRole("SUPER_ADMIN")
                .antMatchers("/user").hasAnyRole("SUPER_ADMIN","ADMIN")
                .antMatchers("/**").permitAll()
                .and()
                .authorizeRequests().antMatchers("/console/**").permitAll()
                .and().formLogin();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
