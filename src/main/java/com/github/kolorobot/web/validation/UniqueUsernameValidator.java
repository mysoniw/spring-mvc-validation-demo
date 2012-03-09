package com.github.kolorobot.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.kolorobot.domain.UserRepository;
import com.github.kolorobot.web.form.CredentialsAware;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, CredentialsAware> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
		if(userRepository == null) {
			throw new IllegalStateException("no repository is set");
		}
	}

	@Override
	public boolean isValid(CredentialsAware value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		if (value.getUsername() == null) {
			return true;
		}
		System.out.println("UniqueUsernameValidator.isValid(): " + userRepository);
		return !userRepository.hasUser(value.getUsername());
	}
}
