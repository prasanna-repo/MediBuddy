package com.medibuddy.exception.resolver;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Prasanna
 *
 */
@ResponseStatus
public class DataIntegrityExceptionResolver extends RuntimeException {
	public DataIntegrityExceptionResolver(String exception) {
		super(exception);
	}
}
