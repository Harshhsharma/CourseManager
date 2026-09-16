package com.example.coursemanager.controller;

import com.example.coursemanager.Dto.CourseRequestDto;
import com.example.coursemanager.Dto.CourseResponseDto;
import com.example.coursemanager.responseStructure.ResponseStructure;
import com.example.coursemanager.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // CREATE COURSE
    @PostMapping
    public ResponseEntity<ResponseStructure<CourseResponseDto>> createCourse(
            @RequestBody CourseRequestDto courseDto) {

        CourseResponseDto responseDto =
                courseService.createCourse(courseDto);

        ResponseStructure<CourseResponseDto> response =
                new ResponseStructure<>(
                        201,
                        "Course created successfully",
                        responseDto
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // GET COURSE BY ID
    @GetMapping("/{courseId}")
    public ResponseEntity<ResponseStructure<CourseResponseDto>> getCourseById(
            @PathVariable Long courseId) {

        CourseResponseDto responseDto =
                courseService.getCourseById(courseId);

        ResponseStructure<CourseResponseDto> response =
                new ResponseStructure<>(
                        200,
                        "Course fetched successfully",
                        responseDto
                );

        return ResponseEntity.ok(response);
    }

    // GET ALL COURSES
    @GetMapping
    public ResponseEntity<ResponseStructure<List<CourseResponseDto>>> getAllCourses() {

        List<CourseResponseDto> courses =
                courseService.getAllCourses();

        ResponseStructure<List<CourseResponseDto>> response =
                new ResponseStructure<>(
                        200,
                        "Courses fetched successfully",
                        courses
                );

        return ResponseEntity.ok(response);
    }

    // UPDATE COURSE
    @PutMapping("/{courseId}")
    public ResponseEntity<ResponseStructure<CourseResponseDto>> updateCourse(
            @PathVariable Long courseId,
            @RequestBody CourseRequestDto courseDto) {

        CourseResponseDto responseDto =
                courseService.updateCourse(courseId, courseDto);

        ResponseStructure<CourseResponseDto> response =
                new ResponseStructure<>(
                        200,
                        "Course updated successfully",
                        responseDto
                );

        return ResponseEntity.ok(response);
    }

    // SOFT DELETE COURSE
    @DeleteMapping("/{courseId}")
    public ResponseEntity<ResponseStructure<String>> deleteCourse(
            @PathVariable Long courseId) {

        courseService.deleteCourse(courseId);

        ResponseStructure<String> response =
                new ResponseStructure<>(
                        200,
                        "Course deleted successfully",
                        null
                );

        return ResponseEntity.ok(response);
    }
}




