package ru.netology.javaqa;

public class NotRegisteredException extends RuntimeException {

    public NotRegisteredException(String name) {
        super("Игрок с именем " + name + " не нйден");
    }
}