package br.com.dio.exception;

public class PixBeingUsedException extends RuntimeException {
    public PixBeingUsedException(String message) {
        super(message);
    }
}
