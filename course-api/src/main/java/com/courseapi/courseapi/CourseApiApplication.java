package com.courseapi.courseapi;

import com.courseapi.courseapi.entity.Category;
import com.courseapi.courseapi.entity.Course;
import com.courseapi.courseapi.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class CourseApiApplication implements CommandLineRunner {

    private final CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(CourseApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        courseRepository.saveAll( Arrays.asList(
                new Course("Java", " bnvguidfgu gbngrsjkbtrkubgiut"),
                new Course("C++", " bnvguidfgu gbngrsjkbtrkubgiut"),
                new Course("TypeScript", " bnvguidfgu gbngrsjkbtrkubgiut"),
                new Course("React.js", " bnvguidfgu gbngrsjkbtrkubgiut")
        ));

    }
}
