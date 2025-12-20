package ru.otus.avidzba.dao;

import ru.otus.avidzba.domain.Question;

import java.util.List;

public interface QuestionDao {
    List<Question> findAll();
}
