package ru.otus.avidzba.service;

import lombok.RequiredArgsConstructor;
import ru.otus.avidzba.dao.QuestionDao;
import ru.otus.avidzba.domain.Answer;
import ru.otus.avidzba.domain.Question;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final IOService ioService;
    private final QuestionDao questionDao;

    @Override
    public void executeTest() {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");
        // Получить вопросы из дао и вывести их с вариантами ответов
        List<Question> questions = questionDao.findAll();
        questions.forEach(x -> ioService.printFormattedLine(x.text() + "%s \n",
                "\n - " + x.answers().stream()
                        .map(Answer::text)
                        .collect(Collectors.joining("; \n - "))));
    }
}
