package ru.otus.avidzba.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.otus.avidzba.config.AppConfig;
import ru.otus.avidzba.dao.CsvQuestionDao;
import ru.otus.avidzba.domain.Question;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@SpringJUnitConfig({AppConfig.class, CsvQuestionDao.class})
class CsvQuestionDaoIT {
    private final CsvQuestionDao csvQuestionDao;

    @Test
    void findAll_whenInvoke_returnAllQuestions() {
        List<Question> questions = csvQuestionDao.findAll();

        assertThat(questions.size(), equalTo(5));
        assertThat(questions.get(0).text(), equalTo("Is there life on Mars?"));
    }
}