package com.dev.backend.entities;

import java.util.Date;

import jakarta.annotation.Generated;
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
@Table(name = "state")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class State {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    private String acronym;
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertionDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date atualizationDate;

}