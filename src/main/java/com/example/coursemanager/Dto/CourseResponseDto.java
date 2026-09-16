package com.example.coursemanager.Dto;

import java.util.List;

public class CourseResponseDto {

    private Long course_id;

    private String name;

    private String duration;

    private Double fees;

    private String description;

    private List<StudentResponseDto> enrolledStudents;

    public CourseResponseDto() {
    }


    public CourseResponseDto(Long course_id, String name, String duration, Double fees, String description) {
        this.course_id = course_id;
        this.name = name;
        this.duration = duration;
        this.fees = fees;
        this.description = description;

    }


    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<StudentResponseDto> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<StudentResponseDto> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
}
