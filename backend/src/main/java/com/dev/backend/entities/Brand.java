package com.dev.backend.entities;

import java.util.Date;

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
@Table(name = "brand")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Brand {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date insertionDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date atualizationDate;
}
