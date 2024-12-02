package com.backend.service.interf;

import com.backend.model.dto.AppointmentDTO;
import com.backend.model.entity.Appointment;
import org.springframework.stereotype.Service;


public interface AppointmentService {
    public Appointment bookAppointment(AppointmentDTO appointmentDTO);
    public boolean validateField(String field);
}
