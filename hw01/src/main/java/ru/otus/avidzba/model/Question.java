package ru.otus.avidzba.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Question {
    private Integer id;

    private String question;

    private List<String> answers;
}
