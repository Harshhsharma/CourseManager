package com.example.coursemanager.Dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CourseRequestDto {


    @NotBlank
    private String name;

    @NotBlank
    private String duration;

    @NotBlank @Positive
    private Double fees;

    @NotBlank  @Size(max = 500)
    private  String description;

    @NotBlank
    private String category;

    @NotBlank
    private String level;

    @NotBlank
    private String mode ;

    @NotNull
    private LocalDate startDate;



    public CourseRequestDto() {
    }

    public CourseRequestDto(String name, String duration, Double fees, String description, String category, String level, String mode, LocalDate startDate) {
        this.name = name;
        this.duration = duration;
        this.fees = fees;
        this.description = description;
        this.category = category;
        this.level = level;
        this.mode = mode;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
