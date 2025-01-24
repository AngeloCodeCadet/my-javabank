package io.codeforall.bootcamp.javabank.persistence;

public class TransactionException extends RuntimeException {
    public TransactionException(String message) {
        super(message);
    }
}
