package com.github.wiriswernek.capsula_do_tempo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.wiriswernek.capsula_do_tempo.exceptions.BusinessException;
import com.github.wiriswernek.capsula_do_tempo.exceptions.ValidationException;
import com.github.wiriswernek.capsula_do_tempo.models.dto.ApiErrors;

@ControllerAdvice
public class ApplicationControllerAdvice {

	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public ApiErrors handleValidationException(ValidationException ex) {
		return new ApiErrors(ex.getMessage());
	}

	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors handleBusinessException(BusinessException ex) {
		return new ApiErrors(ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiErrors handleGenericException(Exception ex) {
		return new ApiErrors("An unexpected error occurred: " + ex.getMessage());
	}
}
