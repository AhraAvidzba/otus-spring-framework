package ru.otus.avidzba.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.avidzba.dao.CsvQuestionDao;
import ru.otus.avidzba.domain.Question;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(properties = {
        "spring.shell.interactive.enabled=false",
        "spring.shell.noninteractive.enabled=false",
        "spring.shell.script.enabled=false"
})

class CsvQuestionDaoIT {
    @Autowired
    private CsvQuestionDao csvQuestionDao;

    @Test
    void findAll_whenInvoke_returnAllQuestions() {
        List<Question> questions = csvQuestionDao.findAll();

        assertThat(questions.size(), equalTo(3));
        assertThat(questions.get(0).text(), equalTo("Is there life on Mars?"));
    }
}