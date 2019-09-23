package br.com.poc.exceptions;

public class AlunoDoesNotExistsException extends RuntimeException {

    public AlunoDoesNotExistsException(final String nome) {
            super(nome);
	}
}
