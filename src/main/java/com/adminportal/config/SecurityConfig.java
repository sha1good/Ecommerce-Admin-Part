package com.adminportal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.adminportal.Utility.SecrityUtility;
import com.adminportal.service.impl.UserSecurityService;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
@ComponentScan(basePackages = "com.bookstore.*")
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	//prePost means we are enabling the preauthorization adn postAuthorization for the user when they want to login
	
	@Autowired
	private Environment env;
	
	
	//This userService is for users' username
	@Autowired
	private UserSecurityService usersecurityservice;
	
	
	//BcryptPasswordEncoder is for users' password
	private BCryptPasswordEncoder passwordEncoder() {
		return SecrityUtility.passwordEncoder();
		
	}
	
	private static final String[] PUBLIC_MATCHERS= {
			"/css/**",
			"/image/**",
			"/font/**",
			"/js/**",
			"/login"
			,"/newUser",
			"/forgetPassword"
			/*,"/myAccount"*/
	};
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
		  /*.antMatchers("/**")*/
		
		.antMatchers(PUBLIC_MATCHERS).
		 permitAll().anyRequest().authenticated();
		
		
		http
		.csrf().disable().cors().disable()
		.formLogin().failureUrl("/login?error")
		.defaultSuccessUrl("/")
		.loginPage("/login").permitAll()
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/?logout").deleteCookies("remember-me").permitAll()
		 .and()
		 .rememberMe();
		      
				
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
	   auth.userDetailsService(usersecurityservice).passwordEncoder(passwordEncoder());
	}
	
		
}
