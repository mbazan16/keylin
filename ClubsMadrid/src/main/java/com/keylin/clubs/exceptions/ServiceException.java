package com.keylin.clubs.exceptions;

public class ServiceException extends Exception {
	private String code;

	public ServiceException(String code) {
		super();
		this.code = code;
	}
	public String getCode() {
		return code;
	}
}
