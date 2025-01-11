package com.dev.backend.util;

import org.springframework.beans.BeanUtils;

import com.dev.backend.dto.PersonClientRequestDto;
import com.dev.backend.entities.Person;

public class PersonClientConverter {
    public static Person converter(PersonClientRequestDto dto){
        Person person = new Person();
        BeanUtils.copyProperties(dto, person);
        return person;
    };
}
