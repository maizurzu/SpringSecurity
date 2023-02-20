package demospringsecurityform.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	//WebSecurityConfigurerAdapter는 deprecated되었기 때문에 아래와 같이 SecurityFilterChain를 @Bean으로 등록

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http.authorizeHttpRequests()
    		.requestMatchers("/","/info").permitAll()
    		.requestMatchers("/admin").hasRole("ADMIN") //admin이라는 role이 없는 유저이기때문에 error가 발
    		.anyRequest().authenticated(); // 이외는 허가가 필요하다.
    		
    	http.formLogin();   		
    	http.httpBasic();

    	return http.build();
    }
    
    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder auth)
            throws Exception {
    	auth.inMemoryAuthentication()
		.withUser("user").password("{noop}123").roles("USER")
							//{noop}: 암호화X
		.and()
		.withUser("admin").password("{noop}!@#").roles("ADMIN");
      
    }

}
