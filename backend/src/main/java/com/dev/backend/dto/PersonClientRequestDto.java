package com.dev.backend.dto;

import org.springframework.beans.BeanUtils;

import com.dev.backend.entities.City;
import com.dev.backend.entities.Person;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import lombok.Data;


public record PersonClientRequestDto(String name, String cpf, String email, 
                                    String address, String cep, City city) { 

    public Person converter(PersonClientRequestDto dto){
        Person person = new Person();
        BeanUtils.copyProperties(dto, person);
        return person;
    };
}
