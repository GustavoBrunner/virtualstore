package com.dev.backend.services.contracts;

import com.dev.backend.entities.Email;

public interface EmailService {
    
    public String sendEmail(Email email);
}