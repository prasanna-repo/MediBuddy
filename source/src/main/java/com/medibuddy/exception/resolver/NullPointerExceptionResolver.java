package com.medibuddy.exception.resolver;

import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Prasanna
 *
 */
@ResponseStatus
public class NullPointerExceptionResolver extends RuntimeException {
	public NullPointerExceptionResolver(String exception) {
		super(exception);
	}
}
