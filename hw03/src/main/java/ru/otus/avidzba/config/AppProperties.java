package ru.otus.avidzba.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class AppProperties implements TestFileNameProvider, TestConfig {

    private String testFileName;

    private int rightAnswersCountToPass;

    public AppProperties(@Value("${test.rightAnswersCountToPass}") String rightAnswersCountToPass,
                         @Value("${test.fileName}") String testFileName) {
        this.rightAnswersCountToPass = Integer.parseInt(rightAnswersCountToPass);
        this.testFileName = testFileName;
    }

    @Override
    public String getTestFileName() {
        return testFileName;
    }

    @Override
    public int getRightAnswersCountToPass() {
        return rightAnswersCountToPass;
    }
}
