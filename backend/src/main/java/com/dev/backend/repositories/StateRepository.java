package com.dev.backend.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.backend.entities.State;

public interface StateRepository extends JpaRepository<State, Long>{
    
}
