package com.example.coursemanager.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long course_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String duration;

    @Column(nullable = false)
    private Double fees;

    @Column(nullable = false , length = 500)
    private String description;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String level;

    @Column(nullable = false)
    private String mode;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private Boolean active;

    public Course() {
    }

    public Course(Long course_id, String name, String duration, Double fees, String description, String category, String level, String mode, LocalDate startDate, Boolean active) {
        this.course_id = course_id;
        this.name = name;
        this.duration = duration;
        this.fees = fees;
        this.description = description;
        this.category = category;
        this.level = level;
        this.mode = mode;
        this.startDate = startDate;
        this.active = active;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
// is_active Boolean
