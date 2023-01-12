package com.tristan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public GreetResponse greet() {
        return new GreetResponse(
                "Hello",
                List.of("Java", "TypeScript"),
                new Person("Alex", 28, 30000.0)
        );
    }

    record Person(String name, int age, double savings){}

    record GreetResponse(
            String greet,
            List<String> favLanguages,
            Person person
    ){}

}
