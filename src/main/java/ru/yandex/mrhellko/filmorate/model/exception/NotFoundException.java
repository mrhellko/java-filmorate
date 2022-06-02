package ru.yandex.mrhellko.filmorate.model.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String s) {
        super(s);
    }
}
