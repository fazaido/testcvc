package com.cvc.crud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -8373826304226329408L;
	
	private String msg;

	public ResourceNotFoundException(final String msg, final Object fieldValue) {
		super(msg);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}
}
