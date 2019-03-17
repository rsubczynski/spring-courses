package com.luv2code.springdemo.mvc.validation;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstrainValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;

	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		return Optional.ofNullable(theCode).map(code -> code.startsWith(coursePrefix)).orElse(true);
	}

}
