package com.example.coursemanager.service;

import com.example.coursemanager.Dto.CourseRequestDto;
import com.example.coursemanager.Dto.CourseResponseDto;

import java.util.List;

public interface CourseService {

    CourseResponseDto createCourse (CourseRequestDto courseDto);

    CourseResponseDto getCourseById(Long courseId);

    List<CourseResponseDto> getAllCourses();

    CourseResponseDto updateCourse(Long courseId, CourseRequestDto courseDto);

    void deleteCourse(Long courseId);

}
