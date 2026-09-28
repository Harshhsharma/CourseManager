package com.example.coursemanager.service;

import com.example.coursemanager.Dto.CourseValidationResponse;

public interface CourseValidationProducer {

    void sendCourseValidationResponse(
            CourseValidationResponse response
    );
}