package ru.otus.avidzba.service;

import ru.otus.avidzba.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAll();

    void printAll();
}
