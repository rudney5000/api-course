package com.courseapi.courseapi.controller;

import com.courseapi.courseapi.entity.Course;
import com.courseapi.courseapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable long id) {
        return courseService.getCourse( id );
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse( course );
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable  long id, @RequestBody Course course) {
        return courseService.updateCourse( id, course );
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable  long id) {
        return courseService.deleteCourse( id );
    }

}
