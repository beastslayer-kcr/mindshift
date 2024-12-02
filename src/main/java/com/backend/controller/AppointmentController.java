package com.backend.controller;


import com.backend.model.dto.AppointmentDTO;
import com.backend.model.entity.Appointment;
import com.backend.service.impl.AppointmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    @Autowired
    private AppointmentServiceImpl appointmentServiceImpl;

    @PostMapping("/book")
    public ResponseEntity<Object> bookAppointment(@RequestBody @Validated AppointmentDTO appointmentDTO) {
        if(!appointmentServiceImpl.validateField(appointmentDTO.getMessage())){
            return new ResponseEntity<>("The field must contain at least 1 words", HttpStatus.BAD_REQUEST);
        }else{
            Appointment savedAppointment = appointmentServiceImpl.bookAppointment(appointmentDTO);
            return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
        }
    }
}
