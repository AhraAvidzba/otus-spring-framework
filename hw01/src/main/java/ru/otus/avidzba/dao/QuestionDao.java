package ru.otus.avidzba.dao;

import ru.otus.avidzba.model.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> findAll();
}
