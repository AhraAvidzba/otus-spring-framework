package ru.otus.avidzba.service;

import ru.otus.avidzba.domain.Student;
import ru.otus.avidzba.domain.TestResult;

public interface TestService {

    TestResult executeTestFor(Student student);
}
