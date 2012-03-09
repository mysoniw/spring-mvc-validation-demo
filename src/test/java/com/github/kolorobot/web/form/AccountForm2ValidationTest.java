package com.github.kolorobot.web.form;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.kolorobot.ValidationTestConfig;
import com.github.kolorobot.domain.UserRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ValidationTestConfig.class)
public class AccountForm2ValidationTest  {
	
	@Autowired
	private Validator validator;

	@Autowired
	private UserRepository userRepositoryMock;
	
		
	@Before
	public void init() {
		// mock is injected and it is a singleton, therefore reset is required
		Mockito.reset(userRepositoryMock);
	}
	
	@Test
	public void validate_DefaultFieldsNotSet_UniqueUsernameValidatorDoesNotRun() {
		validator.validate(new AccountForm2(), AccountForm2.Complete.class);
		
		verify(userRepositoryMock, never()).hasUser(any(String.class));
		
	}
	
	@Test
	public void validate_DefaultFieldstSet_UniqueUsernameValidatorRuns() {
		validator.validate(new AccountForm2("x", "x", "x"), AccountForm2.Complete.class);
		
		verify(userRepositoryMock, times(1)).hasUser("x");
	}
	
}


