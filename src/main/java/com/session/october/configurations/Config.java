package com.session.october.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Config {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService configureGlobal(AuthenticationManagerBuilder builder, PasswordEncoder passwordEncoder)
			throws Exception {
		UserDetails user = User.withUsername("user").password(passwordEncoder.encode("Param@123")).roles("USER")
				.build();

		UserDetails admin = User.withUsername("admin").password(passwordEncoder.encode("Admin@123")).roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user, admin);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().requestMatchers(new AntPathRequestMatcher("/login/**")).permitAll()
				.requestMatchers(new AntPathRequestMatcher("/register/**")).permitAll()
				.requestMatchers(new AntPathRequestMatcher("/internal/**")).permitAll()
//				.requestMatchers(new AntPathRequestMatcher("/employee/**")).hasRole("ADMIN")
				.anyRequest().authenticated().and().exceptionHandling()
				.authenticationEntryPoint(new CustomAuthenticationEntryPoint()).and().httpBasic();

		return http.build();
	}
}