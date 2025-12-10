package ru.otus.avidzba.config;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "test")
@Setter
public class AppProperties implements TestFileNameProvider, TestConfig {

    private String fileName;

    private int rightAnswersCountToPass;

    @Override
    public String getTestFileName() {
        return fileName;
    }

    @Override
    public int getRightAnswersCountToPass() {
        return rightAnswersCountToPass;
    }
}
