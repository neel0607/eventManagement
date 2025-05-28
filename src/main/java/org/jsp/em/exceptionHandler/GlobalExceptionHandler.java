package org.jsp.em.exceptionHandler;

import org.jsp.em.exceptionClasses.NoEventFoundException;
import org.jsp.em.responseStructure.ResponseStructure;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	public ResponseStructure<String> runtimeExceptionHandler(RuntimeException e) {
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatus(400);
		rs.setMessage("Some thing went wrong");
		rs.setBody(e.getMessage());
		return rs;
	}
	
	@ExceptionHandler(NoEventFoundException.class)
	public ResponseStructure<String> noEventFoundExceptionHandler(NoEventFoundException e) {
		ResponseStructure<String> rs = new ResponseStructure<String>();
		rs.setStatus(400);
		rs.setMessage("Some thing went wrong");
		rs.setBody(e.getMessage());
		return rs;
	}
}
