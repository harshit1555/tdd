package com.cognizant.truyum.controller;

import java.util.Date;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cognizant.truyum.exception.CartNotFoundException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.dto.*;
//import com.ct.springboot.restapi.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler({MenuItemNotFoundException.class})
	public ErrorResponseDto menuItemNotFoundException(Exception ex,HttpServletRequest request )
	{
		return new ErrorResponseDto(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
	}
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler({CartNotFoundException.class})
	public ErrorResponseDto cartNotFoundException(Exception ex,HttpServletRequest request )
	{
		return new ErrorResponseDto(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage(), request.getRequestURI());
	}
}
