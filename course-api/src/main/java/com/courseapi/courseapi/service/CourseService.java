package com.courseapi.courseapi.service;

import com.courseapi.courseapi.entity.Course;
import com.courseapi.courseapi.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourse(long id) {
        return courseRepository.findById( id ).orElseThrow( ()-> new IllegalArgumentException("Not found"));
    }

    public Course createCourse(@RequestBody Course course) {
        Optional<Course> courseisThere = courseRepository.findByName( course.getName() );
        if (courseisThere.isPresent()) {
            throw new RuntimeException( "This book already exist" );
        }
        return courseRepository.save( course );
    }

    public Course updateCourse(long id, Course course){
        Course foundCourse = getCourse( id );
        foundCourse.setName( course.getName() );
        foundCourse.setContent( course.getContent() );
        return courseRepository.save( foundCourse );
    }

    public String deleteCourse(long id){
        Course foundCourse = getCourse( id );
         courseRepository.delete( foundCourse );
         return "Course deleted";
    }


}
