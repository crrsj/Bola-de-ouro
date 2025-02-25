package br.com.society.dto;

import org.springframework.validation.FieldError;

public record Validar(String campo,String mensagem) {

	public Validar(FieldError erros) {
		this(erros.getField(),erros.getDefaultMessage());
	}
}
