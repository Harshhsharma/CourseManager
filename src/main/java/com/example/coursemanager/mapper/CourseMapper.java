package com.example.coursemanager.mapper;

import com.example.coursemanager.Dto.CourseRequestDto;
import com.example.coursemanager.Dto.CourseResponseDto;
import com.example.coursemanager.Entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course toEntity(CourseRequestDto courseDto){
        Course course = new Course();

        course.setName(courseDto.getName());
        course.setDuration(courseDto.getDuration());
        course.setFees(courseDto.getFees());
        course.setDescription(courseDto.getDescription());
        course.setCategory(courseDto.getCategory());
        course.setLevel(courseDto.getLevel());
        course.setMode(courseDto.getMode());
        course.setStartDate(courseDto.getStartDate());
        course.setActive(true);
        return course;

    }

    public CourseResponseDto toResponseDto(Course course){

        CourseResponseDto response  = new CourseResponseDto();
        response.setCourse_id(course.getCourse_id());
        response.setName(course.getName());
        response.setDuration(course.getDuration());
        response.setFees(course.getFees());
        response.setDescription(course.getDescription());
        return response;
    }
     public void updateEntityFromDto(CourseRequestDto courseDto , Course course){
         course.setName(courseDto.getName());
         course.setDuration(courseDto.getDuration());
         course.setFees(courseDto.getFees());
         course.setDescription(courseDto.getDescription());
         course.setCategory(courseDto.getCategory());
         course.setLevel(courseDto.getLevel());
         course.setMode(courseDto.getMode());
         course.setStartDate(courseDto.getStartDate());
     }
}
