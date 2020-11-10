package com.medibuddy.exception.resolver;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Prasanna
 *
 */
@ResponseStatus
public class EmptyResultDataAccessExceptionResolver extends RuntimeException {
	public EmptyResultDataAccessExceptionResolver(String exception) {
		super(exception);
	}
}

