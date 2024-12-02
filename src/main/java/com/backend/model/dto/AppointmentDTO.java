package com.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    @Column(name = "Name", nullable = false)
    private String fullName;

    @Column(name = "Mobile",nullable = false)
    private String contactNo;

    @Column(name = "Email",nullable = false)
    private String email;

    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private LocalDate appointmentDate;

}
