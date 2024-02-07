package com.treinamento.resources.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.treinamento.services.exeptions.ObjectNotFoundExeption;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResouceExeptionHandle {
	
	@ExceptionHandler(ObjectNotFoundExeption.class)
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundExeption e,HttpServletRequest request){
		StandarError err = new StandarError(HttpStatus.NOT_FOUND.value(), e.getMessage(),System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}