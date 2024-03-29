package com.Student.Management.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8656792281771408698L;

	public ResourceNotFoundException()
	{
		this("Resource not found!");
	}
	
	public ResourceNotFoundException(String message)
	{
		this(message, null);
	}
	
	public ResourceNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
