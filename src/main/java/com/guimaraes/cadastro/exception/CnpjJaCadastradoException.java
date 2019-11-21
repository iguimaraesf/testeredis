package com.guimaraes.cadastro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "CNPJ já cadastrado")
public class CnpjJaCadastradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 181235349751856334L;

	public CnpjJaCadastradoException() {
		super();
	}

	public CnpjJaCadastradoException(String message) {
		super(message);
	}
}
