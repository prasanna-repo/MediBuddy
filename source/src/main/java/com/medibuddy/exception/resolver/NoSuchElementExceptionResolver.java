package com.medibuddy.exception.resolver;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Prasanna
 *
 */
@ResponseStatus
public class NoSuchElementExceptionResolver extends RuntimeException {
	public NoSuchElementExceptionResolver(String exception) {
		super(exception);
	}
}
