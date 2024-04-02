package ru.itmentor.spring.boot_security.demo.exception_handing;

public class NoSuchUserException extends RuntimeException{
    public NoSuchUserException(String message) {
        super(message);
    }
}
