package com.dev.backend.services.contracts;

import com.dev.backend.dto.PersonClientRequestDto;
import com.dev.backend.entities.Person;

public interface PersonClientService {
    
    public Person create(PersonClientRequestDto dto);
}
