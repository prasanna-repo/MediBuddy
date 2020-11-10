package com.medibuddy.exception.resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.medibuddy.controller.DoctorController;
import com.medibuddy.model.ResponseInfo;

/**
 * @author Prasanna
 *
 */
@ControllerAdvice
public class CustomExceptionResolver {
	
	private static final Logger LOG = LoggerFactory.getLogger(DoctorController.class);

	/**
	 * @Resolver - Data Integrity Exception Resolver
	 *
	 */
	@ExceptionHandler({ DataIntegrityExceptionResolver.class })
	protected ResponseEntity<Object> customKeyConstraintExceptionResolver(DataIntegrityExceptionResolver ex) {
		ResponseInfo error = new ResponseInfo();
		error.setStatusCode(547);
		error.setStatus(false);
		error.setMessage(ex.getMessage());
		LOG.error("{} {}",error.getStatusCode(),error.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	/**
	 * @Resolver - Data Not Found Exception Resolver
	 *
	 */
	@ExceptionHandler({ DataNotFoundExceptionResolver.class })
	protected ResponseEntity<Object> customDataNotFoundExceptionResolver(DataNotFoundExceptionResolver ex) {
		ResponseInfo error = new ResponseInfo();
		error.setStatusCode(404);
		error.setStatus(false);
		error.setMessage(ex.getMessage());
		LOG.error("{} {}",error.getStatusCode(),error.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * @Resolver - Null Pointer Exception Resolver
	 *
	 */
	@ExceptionHandler({ NullPointerExceptionResolver.class })
	protected ResponseEntity<Object> customNullPointerExceptionResolver(NullPointerExceptionResolver ex) {
		ResponseInfo error = new ResponseInfo();
		error.setStatusCode(404);
		error.setStatus(false);
		error.setMessage(ex.getMessage());
		LOG.error("{} {}",error.getStatusCode(),error.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * @Resolver - Empty Result DataAccess Exception Resolver
	 *
	 */
	@ExceptionHandler({ EmptyResultDataAccessExceptionResolver.class })
	protected ResponseEntity<Object> customEmptyResultDataAccessExceptionResolver(EmptyResultDataAccessExceptionResolver ex) {
		ResponseInfo error = new ResponseInfo();
		error.setStatusCode(500);
		error.setStatus(false);
		error.setMessage(ex.getMessage());
		LOG.error("{} {}",error.getStatusCode(),error.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * @Resolver - No Such Element Exception Resolver
	 *
	 */
	@ExceptionHandler({ NoSuchElementExceptionResolver.class })
	protected ResponseEntity<Object> customNoSuchElementExceptionResolver(NoSuchElementExceptionResolver ex) {
		ResponseInfo error = new ResponseInfo();
		error.setStatusCode(500);
		error.setStatus(false);
		error.setMessage(ex.getMessage());
		LOG.error("{} {}",error.getStatusCode(),error.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
