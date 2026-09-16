package com.example.coursemanager.respository;

import com.example.coursemanager.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRespository extends JpaRepository<Course , Long> {

    List<Course> findByActiveTrue();
}
