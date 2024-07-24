package com.microservice.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.microservice.account.service.UserinfoService;

@Configuration
@EnableWebSecurity
public class SecurityConfig { 
	
	@Autowired
	private UserinfoService userinfoService;

	/* configure filter chain for apis */
	@Bean //<-- to register this filterchain with spring 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer:: disable)
            .authorizeHttpRequests(authorize -> authorize
            	.antMatchers(HttpMethod.GET,"/api/login").authenticated()
            	.antMatchers(HttpMethod.POST,"/api/Employee/add/{managerId}").hasAuthority("HR")
            	.antMatchers(HttpMethod.POST,"/api/HR/getHRUserID/{userinfoId}").hasAuthority("HR")
            	.antMatchers(HttpMethod.GET,"/api/Employee/getEmployeeUserID/{userinfoID}").permitAll()
            	.antMatchers(HttpMethod.POST,"/api/Manager/add").hasAuthority("HR")
            	
            	.antMatchers(HttpMethod.GET,"/api/hr/manager/employee").hasAuthority("HR")
            	.antMatchers(HttpMethod.GET,"/api/Employee/getAll").hasAuthority("HR")
            	.antMatchers(HttpMethod.GET,"/api/Manager/getAll").hasAuthority("HR")      
            	.antMatchers(HttpMethod.GET,"/api/Manager/getManagerUserID/{userinfoId}").hasAuthority("MANAGER")   
            	.antMatchers(HttpMethod.PUT,"/api/HR/updateManager/{employeeId}/{managerId}").hasAuthority("HR")
            	.antMatchers(HttpMethod.POST,"/api/Items/add").hasAuthority("HR")
            	.antMatchers(HttpMethod.GET,"/api/Manager/empSuper/{managerID}").hasAuthority("MANAGER")
            	.antMatchers(HttpMethod.GET,"api/getHistory/Manager/{managerId}").hasAuthority("MANAGER")
            	.antMatchers(HttpMethod.POST,"/api/addPoints/{managerId}/{employeeId}").hasAuthority("MANAGER")
            	.antMatchers(HttpMethod.GET,"/api/Items/getAll").permitAll()
            	.antMatchers(HttpMethod.POST,"/api/Employee/redeemItem/{employeeId}/{itemId}").hasAuthority("EMPLOYEE")
            	.antMatchers(HttpMethod.GET,"/api/Employee/getItems/{employeeId}").hasAuthority("EMPLOYEE")
                .anyRequest().permitAll()
            )
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }

	/* AuthenticationManager : in-memory / jdbc */
	
	public AuthenticationManager authentication() {
		
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setPasswordEncoder(getEncoder());
		dao.setUserDetailsService(userinfoService);
		ProviderManager manager = new ProviderManager(dao);
		return manager;
	}
	
	@Bean
	public PasswordEncoder getEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}