package ru.otus.avidzba.domain;

import java.util.List;

public record Question(String text, List<Answer> answers) {
}
