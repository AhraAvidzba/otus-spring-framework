package ru.otus.avidzba.service;

public interface IOService {
    void printLine(String s);

    void printFormattedLine(String s, Object... args);
}
