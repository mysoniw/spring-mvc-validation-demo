package com.github.kolorobot;

import javax.validation.Validator;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.github.kolorobot.domain.UserRepository;

@Configuration
public class ValidationTestConfig {
	
	@Bean
	public UserRepository userRepository() {		
		return Mockito.mock(UserRepository.class);
	}
	
	@Bean
	public Validator validator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		return validator;
	}

	
	
}