package com.algaworks.curso.jpa2.service.exception;

public class NegocioException extends Exception {
	
	private static final long serialVersionUID = -7757794066984878495L;

	public NegocioException(String message) {
		super(message);
	}
}
