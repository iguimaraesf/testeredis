package com.guimaraes.cadastro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "CPF já cadastrado")
public class CpfJaCadastradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 954727135704896860L;

	public CpfJaCadastradoException() {
		super();
	}

	public CpfJaCadastradoException(String message) {
		super(message);
	}
}
