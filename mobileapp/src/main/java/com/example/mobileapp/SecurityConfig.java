package com.example.mobileapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.sql.DataSource;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.context.annotation.Bean;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().

				authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated()
				.and().httpBasic();
  }



  @Autowired
  private DataSource datasource;

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
          return new BCryptPasswordEncoder();
  }


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("usertest").password("{noop}password").roles("USER");


 /*   auth.jdbcAuthentication().dataSource(datasource).usersByUsernameQuery(
      "select username as principal,password as credentials,active from users where username=?")
      .authoritiesByUsernameQuery(
                      "select username as principal,role as role from users_roles where username=?")
      .rolePrefix("ROLE_").passwordEncoder(bCryptPasswordEncoder());*/
	}
}
