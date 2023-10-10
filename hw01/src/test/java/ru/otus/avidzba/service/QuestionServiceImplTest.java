package ru.otus.avidzba.service;

import org.mockito.Mockito;
import ru.otus.avidzba.dao.CsvQuestionDao;
import ru.otus.avidzba.dao.QuestionDao;

class QuestionServiceImplTest {
    private final QuestionDao questionDao = Mockito.mock(CsvQuestionDao.class);
//    private final QuestionServiceImpl questionService = new QuestionServiceImpl(questionDao);
//
//    @Test
//    void findAll_whenInvoke_returnAllQuestions() {
//        when(questionDao.findAll()).thenReturn(List.of(new Question(1, "question1", List.of()), new Question(1, "question2", List.of())));
//        assertThat(questionService.findAll().size(), equalTo(2));
//        assertThat(questionService.findAll().get(0).getQuestion(), equalTo("question1"));
//        assertThat(questionService.findAll().get(1).getQuestion(), equalTo("question2"));
//    }
}