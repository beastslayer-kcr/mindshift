package com.backend.repository;

import com.backend.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
}
