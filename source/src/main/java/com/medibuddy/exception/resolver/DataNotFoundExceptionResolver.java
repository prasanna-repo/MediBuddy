package com.medibuddy.exception.resolver;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Prasanna
 *
 */
@ResponseStatus
public class DataNotFoundExceptionResolver extends RuntimeException {
	public DataNotFoundExceptionResolver(String exception) {
		super(exception);
	}
}
