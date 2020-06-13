package com.palim.ecommerce;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
//		builder.inMemoryAuthentication().withUser("farti").password("{noop}farti").roles("USER")
//        .and()
//        .withUser("admin").password("{noop}password").roles("ADMIN");
		builder.inMemoryAuthentication().withUser("farti").password("farti").roles("USER");
//		builder
//		.jdbcAuthentication()
//		.dataSource(dataSource)
//		.withDefaultSchema()
//		.withUser(
//				User.withUsername("ffff")
//				.password("ffff")
//				.roles("USER")
//				);

	}
	

	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
//		.loginPage("/loginn");
//		http.authorizeRequests().anyRequest().authenticated();
		http.authorizeRequests().antMatchers("/AfficherClient").hasRole("USER");
	} 
	
	@Bean
	public PasswordEncoder getPasswordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}
}
