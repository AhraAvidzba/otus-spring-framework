package ru.otus.avidzba.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.avidzba.dao.CsvQuestionDao;
import ru.otus.avidzba.dao.QuestionDao;
import ru.otus.avidzba.domain.Answer;
import ru.otus.avidzba.domain.Question;
import ru.otus.avidzba.domain.Student;
import ru.otus.avidzba.domain.TestResult;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class QuestionServiceImplTest {
    private final IOService ioService = Mockito.mock(StreamsIOService.class);
    private final QuestionDao questionDao = Mockito.mock(CsvQuestionDao.class);

    private final TestServiceImpl questionService = new TestServiceImpl(ioService, questionDao);

    @Test
    void executeTestFor_whenInvokeWithStudent_returnResultOfTest() {
        List<Question> questions = makeQuestions();
        Student student = makeStudent();

        when(questionDao.findAll()).thenReturn(List.of(questions.get(0), questions.get(1)));
        when(ioService.readIntForRangeWithPrompt(anyInt(), anyInt(), anyString(), anyString())).thenReturn(1);

        TestResult testResult = questionService.executeTestFor(student);
        assertThat(testResult.getRightAnswersCount(), equalTo(1));
        assertThat(testResult.getAnsweredQuestions(), equalTo(questions));
    }

    private Student makeStudent() {
        return new Student("first name", "last name");
    }

    private List<Question> makeQuestions() {
        Answer answer1 = new Answer("answer1", false);
        Answer answer2 = new Answer("answer1", true);
        Answer answer3 = new Answer("answer3", true);
        Answer answer4 = new Answer("answer4", false);
        Question question1 = new Question("question1", List.of(answer1, answer2));
        Question question2 = new Question("question2", List.of(answer3, answer4));
        return List.of(question1, question2);
    }
}