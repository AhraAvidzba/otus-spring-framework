package ru.otus.avidzba;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.avidzba.service.QuestionService;


public class StudentsTestApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService questionService = context.getBean(QuestionService.class);
        questionService.printAll();
        context.close();
    }
}
