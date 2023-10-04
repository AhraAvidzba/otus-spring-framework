package ru.otus.avidzba.dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.otus.avidzba.exceptions.ResourceNotFoundException;
import ru.otus.avidzba.model.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class CsvQuestionDao implements QuestionDao {
    private String fileName;

    private static List<String> getFileFromResourceAsList(String fileName) {
        List<String> lines = new ArrayList<>();
        ClassLoader classLoader = CsvQuestionDao.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        if (inputStream == null) {
            throw new ResourceNotFoundException("file not found! " + fileName);
        } else {
            try (inputStream; InputStreamReader streamReader =
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                 BufferedReader reader = new BufferedReader(streamReader)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                throw new ResourceNotFoundException("Can not read csv file");
            }
        }
        return lines;
    }

    @Override
    public List<Question> findAll() {
        List<String> lines = getFileFromResourceAsList(fileName);
        List<Question> questions = new ArrayList<>();
        for (String line : lines) {
            String[] data = line.split(",");
            if (data[0].equals("id")) {
                continue;
            }
            List<String> answers = Arrays.stream(data[2].split(":")).toList();
            Question question = new Question(Integer.parseInt(data[0]), data[1], answers);
            questions.add(question);
        }
        return questions;
    }
}
