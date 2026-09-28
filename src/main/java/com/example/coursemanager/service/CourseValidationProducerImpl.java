package com.example.coursemanager.service;

import com.example.coursemanager.Dto.CourseValidationResponse;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CourseValidationProducerImpl
        implements CourseValidationProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public CourseValidationProducerImpl(
            KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendCourseValidationResponse(
            CourseValidationResponse response) {

        kafkaTemplate.send(
                "course-validation-response",
                response
        );
    }
}
