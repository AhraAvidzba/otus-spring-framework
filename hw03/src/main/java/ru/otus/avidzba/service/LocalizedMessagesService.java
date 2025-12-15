package ru.otus.avidzba.service;

public interface LocalizedMessagesService {
    String getMessage(String code, Object ...args);
}
