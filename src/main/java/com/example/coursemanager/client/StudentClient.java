package com.example.coursemanager.client;

import com.example.coursemanager.Dto.StudentResponseDto;
import com.example.coursemanager.responseStructure.ResponseStructure;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service")
public interface StudentClient {

    @GetMapping("/students/course/{courseId}")
    ResponseEntity<ResponseStructure<List<StudentResponseDto>>> getStudentsByCourseId(
            @PathVariable Long courseId
    );

}