package com.neu.spring.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.neu.spring.pojo.User;

public class UserValidator implements Validator {

	public boolean supports(Class aClass) {
		return aClass.equals(User.class);
	}

	public void validate(Object obj, Errors errors) {
		User user = (User) obj;

	}
}
