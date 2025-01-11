package com.dev.backend.dto;

import com.dev.backend.entities.City;

public record PersonClientRequestDto(String name, String cpf, String email, 
                                    String address, String cep, City city) { 
}
