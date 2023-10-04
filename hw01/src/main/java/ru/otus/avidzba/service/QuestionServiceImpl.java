package ru.otus.avidzba.service;

import lombok.RequiredArgsConstructor;
import ru.otus.avidzba.dao.QuestionDao;
import ru.otus.avidzba.model.Question;

import java.util.List;

@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;

    @Override
    public List<Question> findAll() {
        return questionDao.findAll();
    }

    @Override
    public void printAll() {
        findAll().forEach(x -> System.out.println(x.getQuestion()));
    }
}
