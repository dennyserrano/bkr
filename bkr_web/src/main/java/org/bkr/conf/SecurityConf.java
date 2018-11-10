//package org.bkr.conf;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConf extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		
//		
//		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
//        .withUser("user")
//         .password("password")
//         .roles("USER");
//	}
//	
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http
//		.authorizeRequests()
//		.antMatchers("/login").permitAll()
//		.antMatchers("/secure/**").permitAll()
//		.antMatchers("/home").authenticated()
//        .anyRequest().authenticated()
//        .and()
//        .httpBasic();
////        .formLogin()
////        .loginPage( "/login" )
////        .defaultSuccessUrl( "/home" );
//        
//	}
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
////		web.ignoring().antMatchers("/css/*.css");
////		web.ignoring().antMatchers("/js/*.js");
//	}
//	
//}
