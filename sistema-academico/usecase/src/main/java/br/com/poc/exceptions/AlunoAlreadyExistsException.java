package br.com.poc.exceptions;

public class AlunoAlreadyExistsException extends RuntimeException {

    public AlunoAlreadyExistsException(final String nome) {
            super(nome);
	}
}
