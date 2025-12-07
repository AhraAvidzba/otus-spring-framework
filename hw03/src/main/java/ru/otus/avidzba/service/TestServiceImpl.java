package ru.otus.avidzba.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.avidzba.dao.QuestionDao;
import ru.otus.avidzba.domain.Answer;
import ru.otus.avidzba.domain.Student;
import ru.otus.avidzba.domain.TestResult;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final IOService ioService;

    private final QuestionDao questionDao;

    @Override
    public TestResult executeTestFor(Student student) {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");
        var questions = questionDao.findAll();
        var testResult = new TestResult(student);
        for (var question : questions) {
            int i = 0;
            var isAnswerValid = false;
            ioService.printLine(question.text());
            for (Answer answer : question.answers()) {
                ioService.printFormattedLine("    %d - " + answer.text(), ++i);
            }
            int ans = ioService.readIntForRangeWithPrompt(1, question.answers().size(),
                    "Enter number of right answer", "Incorrect number");
            if (question.answers().get(ans - 1).isCorrect()) {
                isAnswerValid = true;
            }
            testResult.applyAnswer(question, isAnswerValid);
            ioService.printLine("");
        }
        return testResult;
    }
}
