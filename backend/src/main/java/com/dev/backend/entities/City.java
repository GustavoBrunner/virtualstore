package com.dev.backend.entities;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "city")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long stateId;
    
    private String name;
    @JsonIgnore
    private State state;
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertionDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date atualizationDate;
}
