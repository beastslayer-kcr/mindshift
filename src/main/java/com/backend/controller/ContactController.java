package com.backend.controller;

import com.backend.model.dto.ContactMessageDTO;
import com.backend.model.entity.ContactMessage;
import com.backend.service.impl.ContactMessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
    @Autowired
    private ContactMessageServiceImpl contactMessageServiceImpl;

    @PostMapping("/book")
    public ResponseEntity<Object> bookAppointment(@RequestBody @Validated ContactMessageDTO contactMessageDTO) {
        if(!contactMessageServiceImpl.validateField(contactMessageDTO.getMessage())){
            return new ResponseEntity<>("The field must contain at least 50 words", HttpStatus.BAD_REQUEST);
        }else{
            ContactMessage savedContact = contactMessageServiceImpl.contact(contactMessageDTO);
            return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
        }
    }
}
