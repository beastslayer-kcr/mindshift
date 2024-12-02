package com.backend.service.interf;

import com.backend.model.dto.ContactMessageDTO;
import com.backend.model.entity.ContactMessage;

public interface ContactMessageService {
    public ContactMessage contact(ContactMessageDTO appointmentDTO);
    public boolean validateField(String field);
}
