package com.example.coursemanager.consumer;

import com.example.coursemanager.Dto.CourseValidationEvent;
import com.example.coursemanager.Dto.CourseValidationResponse;
import com.example.coursemanager.Entity.Course;
import com.example.coursemanager.respository.CourseRespository;
import com.example.coursemanager.service.CourseValidationProducer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CourseValidationConsumer {

    private final CourseRespository courseRepository;

    private final CourseValidationProducer producer;

    public CourseValidationConsumer(
            CourseRespository courseRepository,
            CourseValidationProducer producer) {
        System.out.println("🔥 COURSE VALIDATION CONSUMER BEAN CREATED");
        this.courseRepository = courseRepository;
        this.producer = producer;
    }

    @KafkaListener(
            topics = "course-validation-to-course",
            groupId = "course-validation-group"
    )
    @KafkaListener(
            topics = "course-validation-to-course",
            groupId = "course-validation-group"
    )
    public void consumeCourseValidationRequest(
            CourseValidationEvent event) {

        // 👇 YAHAN DAAL
        System.out.println(
                "COURSE SERVICE RECEIVED: " + event.getCourseId()
        );

        Course course = courseRepository.findById(event.getCourseId())
                .orElse(null);

        boolean courseExists = course != null;

        CourseValidationResponse response =
                new CourseValidationResponse(
                        event.getRequestId(),
                        event.getStudentId(),
                        event.getCourseId(),
                        courseExists
                );

        producer.sendCourseValidationResponse(response);
    }
}
