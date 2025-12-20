package ru.otus.avidzba.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ru.otus.avidzba.config.TestFileNameProvider;
import ru.otus.avidzba.dao.dto.QuestionDto;
import ru.otus.avidzba.domain.Question;
import ru.otus.avidzba.exceptions.QuestionReadException;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CsvQuestionDao implements QuestionDao {
    private final TestFileNameProvider fileNameProvider;

    @Override
    public List<Question> findAll() {
        try (var reader = new InputStreamReader(
                new ClassPathResource(fileNameProvider.getTestFileName())
                        .getInputStream(), StandardCharsets.UTF_8)) {

            var beans = new CsvToBeanBuilder<QuestionDto>(reader)
                    .withSeparator(';')
                    .withSkipLines(1)
                    .withType(QuestionDto.class)
                    .build()
                    .parse();

            return beans.stream()
                    .map(QuestionDto::toDomainObject)
                    .toList();

        } catch (Exception e) {
            throw new QuestionReadException("Error reading csv file", e);
        }
    }
}
