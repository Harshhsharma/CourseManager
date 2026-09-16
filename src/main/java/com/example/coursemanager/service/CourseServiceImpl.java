package com.example.coursemanager.service;

import com.example.coursemanager.Dto.CourseRequestDto;
import com.example.coursemanager.Dto.CourseResponseDto;
import com.example.coursemanager.Dto.StudentResponseDto;
import com.example.coursemanager.Entity.Course;
import com.example.coursemanager.client.StudentClient;
import com.example.coursemanager.exception.ResourceNotFoundException;
import com.example.coursemanager.mapper.CourseMapper;
import com.example.coursemanager.responseStructure.ResponseStructure;
import com.example.coursemanager.respository.CourseRespository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRespository courseRespository;

    private final CourseMapper courseMapper;
    private final StudentClient studentClient;

    public CourseServiceImpl(CourseRespository courseRespository , CourseMapper courseMapper , StudentClient studentClient) {
        this.courseRespository = courseRespository;
        this.courseMapper = courseMapper;
        this.studentClient = studentClient;
    }

    @Override
    public CourseResponseDto createCourse(CourseRequestDto courseDto) {

        Course course = courseMapper.toEntity(courseDto);
        Course SavedCourse = courseRespository.save(course);
        return courseMapper.toResponseDto(SavedCourse);


    }

    @Override
    public CourseResponseDto getCourseById(Long courseId) {

        Course course = courseRespository.findById(courseId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "course not found with id :" + courseId));

        CourseResponseDto response =
                courseMapper.toResponseDto(course);

        ResponseEntity<ResponseStructure<List<StudentResponseDto>>> studentResponse =
                studentClient.getStudentsByCourseId(courseId);

        List<StudentResponseDto> students =
                studentResponse.getBody().getData();

        response.setEnrolledStudents(students);

        return response;
    }

    @Override
    public List<CourseResponseDto> getAllCourses() {
        List<Course> courses = courseRespository.findByActiveTrue();

         return courses.stream().map(courseMapper::toResponseDto).toList();
    }

    @Override
    public CourseResponseDto updateCourse(Long courseId, CourseRequestDto courseDto) {

        Course course = courseRespository.findById(courseId)
                .orElseThrow(()-> new ResourceNotFoundException("course not found with id :" +courseId));

        courseMapper.updateEntityFromDto(courseDto , course);
        Course updatedCourse= courseRespository.save(course);
        return courseMapper.toResponseDto(updatedCourse);
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course course = courseRespository.findById(courseId)
                .orElseThrow(()-> new ResourceNotFoundException("course not found with id :" +courseId));
               course.setActive(false);
        courseRespository.save(course);

    }
}
