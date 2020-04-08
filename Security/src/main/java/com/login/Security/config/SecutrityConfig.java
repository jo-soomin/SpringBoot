package com.login.Security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecutrityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/adminOnly").hasAuthority("ROLE_ADMIN")
		.antMatchers("/**").permitAll() // 넓은 범위의 url을 아래에 배치.
		.anyRequest().authenticated()
		.and()
		.formLogin().defaultSuccessUrl("/")
		// formLogin: 다른 옵션 설정이 없는 경우 씨큐리티가 제공하는 기본 로그인 form 페이지 사용
		.and()
		.logout().logoutSuccessUrl("/");  
	    // 로그아웃 기본 url은 (/logout)
	    // 새로 설정하려면 .logoutUrl("url") 사용  

	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN")
		.and()
		.withUser("guest").password(passwordEncoder().encode("1234")).roles("GUEST")
		.and()
		.withUser("josoomin").password(passwordEncoder().encode("1234")).roles("ADMIN");
		
	}

	 // passwordEncoder() 추가
	  @Bean
	  public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();

	
	  }

}
