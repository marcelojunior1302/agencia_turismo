package br.edu.univasf.agencia_turismo.util;

public class ReservaNaoEncontradaException extends Exception {

    public ReservaNaoEncontradaException() {
        super();
    }

    public ReservaNaoEncontradaException(String message) {
        super(message);
    }

    public ReservaNaoEncontradaException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReservaNaoEncontradaException(Throwable cause) {
        super(cause);
    }
}
