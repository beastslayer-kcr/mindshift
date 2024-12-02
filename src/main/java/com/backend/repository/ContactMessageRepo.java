package com.backend.repository;

import com.backend.model.entity.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactMessageRepo extends JpaRepository<ContactMessage, Integer> {

}