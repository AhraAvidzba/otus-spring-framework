package ru.otus.avidzba.dao;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import ru.otus.avidzba.config.TestFileNameProvider;
import ru.otus.avidzba.dao.dto.QuestionDto;
import ru.otus.avidzba.domain.Question;
import ru.otus.avidzba.exceptions.QuestionReadException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CsvQuestionDao implements QuestionDao {
    private final TestFileNameProvider fileNameProvider;

    @Override
    public List<Question> findAll() {
        List<QuestionDto> beans;
        try (FileReader reader = new FileReader(fileNameProvider.getTestFileName())) {
            beans = new CsvToBeanBuilder(reader)
                    .withSeparator(';')
                    .withSkipLines(1)
                    .withType(QuestionDto.class).build().parse();
        } catch (IOException e) {
            throw new QuestionReadException("Error reading csv file", e);
        }
        return beans.stream().map(QuestionDto::toDomainObject).collect(Collectors.toList());
    }
}
