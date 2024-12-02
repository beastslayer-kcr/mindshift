package com.backend.service.impl;

import com.backend.exception.SlotUnavailableException;
import com.backend.model.dto.AppointmentDTO;
import com.backend.model.entity.Appointment;
import com.backend.repository.AppointmentRepo;
import com.backend.service.interf.AppointmentService;
import com.backend.validation.WordCountValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepo appointmentRepo;
    private final WordCountValidator wordCountValidator = new WordCountValidator(1);
    @Transactional
    @Override
    public Appointment bookAppointment(AppointmentDTO appointmentDTO) {
        // Map DTO to Entity
        Appointment appointment = new Appointment();
        appointment.setFullName(appointmentDTO.getFullName());
        appointment.setContactNo(appointmentDTO.getContactNo());
        appointment.setEmail(appointmentDTO.getEmail());
        appointment.setAppointmentDate(appointmentDTO.getAppointmentDate());
        appointment.setMessage(appointmentDTO.getMessage());
        System.out.println(appointmentDTO);
        System.out.println("testing");
        // Save to repository
        try {
        Appointment savedAppointment = appointmentRepo.save(appointment);
        return appointment;
        } catch (Exception e) {
            System.out.println(e);
            throw new SlotUnavailableException("Error occurred while saving the appointment.", e);
        }

    }
    public boolean validateField(String field) { return wordCountValidator.isValid(field); }
}
