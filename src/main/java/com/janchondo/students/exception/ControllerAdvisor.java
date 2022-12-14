package com.janchondo.students.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
//	@ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<Object> handleUserNotFoundException(
//        UserNotFoundException ex, WebRequest request) {
//
//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("timestamp", LocalDateTime.now());
//        body.put("message", "User not found");
//
//        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
//    }
	
//	@ExceptionHandler(NoDataFoundException.class)
//    public ResponseEntity<Object> handleNodataFoundException(
//        NoDataFoundException ex, WebRequest request) {
//
//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("timestamp", LocalDateTime.now());
//        body.put("message", "No users found");
//
//        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
//    }
	
//	@Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//        MethodArgumentNotValidException ex, HttpHeaders headers, 
//        HttpStatus status, WebRequest request) {
//
//        Map<String, Object> body = new LinkedHashMap<>();
//        body.put("timestamp", LocalDate.now());
//        body.put("status", status.value());
//
//        List<String> errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(x -> x.getDefaultMessage())
//                .collect(Collectors.toList());
//
//        body.put("errors", errors);
//
//        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
//    }
	
	@ExceptionHandler(value = { UserNotFoundException.class })
	protected ResponseEntity<Object> handleUserNotFound(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "User not found";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
	
	@ExceptionHandler(value = { NoDataFoundException.class })
	protected ResponseEntity<Object> handleNoDataFound(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Data not found";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
	
	@ExceptionHandler(value = { NumberFormatException.class })
	protected ResponseEntity<Object> handleNoFormatFound(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Incorrect ID";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE, request);
	}
}
