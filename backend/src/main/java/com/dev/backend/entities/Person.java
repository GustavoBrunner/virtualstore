package com.dev.backend.entities;


import java.util.Date;

import com.dev.backend.entities.Exceptions.InvalidCpfException;
import com.dev.backend.entities.Exceptions.InvalidEmailException;
import com.dev.backend.util.CpfValidator;
import com.dev.backend.util.EmailValidator;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Nonnull
    private String name;
    @Nonnull
    private String email;

    @Nonnull
    private String cpf;
    @Nonnull
    private String password;
    @Nonnull
    private String address;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;
    
    @Nonnull
    private String cep;
    private Date insertionDate;
    private Date atualizationDate;

    public void setEmail(String email) throws Exception{
        
        this.email = email;
    }
    public void setCpf(String cpf) throws Exception{
        
        this.cpf = cpf;
    }
}
