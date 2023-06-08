package ru.netology;

public class AlreadyExistsException extends RuntimeException{
    public AlreadyExistsException(String e) {
        super(e);
    }
}
