package com.backend.service.impl;

import com.backend.exception.ContactSetupException;
import com.backend.exception.SlotUnavailableException;
import com.backend.model.dto.ContactMessageDTO;
import com.backend.model.entity.ContactMessage;
import com.backend.repository.ContactMessageRepo;
import com.backend.service.interf.ContactMessageService;
import com.backend.validation.WordCountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service
public class ContactMessageServiceImpl implements ContactMessageService {

    @Autowired
    private ContactMessageRepo contactMessageRepo;
    private final WordCountValidator wordCountValidator = new WordCountValidator(0);


    @Override
    public ContactMessage contact(ContactMessageDTO contactMessageDTO) {
        // Map DTO to Entity
        ContactMessage contact = new ContactMessage();
        contact.setFullName(contactMessageDTO.getFullName());
        contact.setContactNo(contactMessageDTO.getContactNo());
        contact.setEmail(contactMessageDTO.getEmail());
        contact.setMessage(contactMessageDTO.getMessage());

        // Save to repository
        try{
            ContactMessage savedContact = contactMessageRepo.save(contact);
            return savedContact;
        } catch (ContactSetupException e){
            throw new ContactSetupException("Error occurred while saving the appointment.", e);
        }

    }

    public boolean validateField(String message) {
        return wordCountValidator.isValid(message);
    }
}
