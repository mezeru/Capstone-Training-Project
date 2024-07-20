package com.microservice.account.exceptions;

public class ResourceNotFound extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -497621985800218592L;
	private String message;

	public ResourceNotFound(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
