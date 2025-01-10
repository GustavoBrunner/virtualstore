package com.dev.backend.services;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entities.State;
import com.dev.backend.repositories.StateRepository;
import com.dev.backend.services.contracts.StateService;

@Service
public class StateServiceImpl implements StateService  {
    private final StateRepository stateRepository;
    
    @Autowired    
    public StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public List<State> getAll(){
        return stateRepository.findAll();
    }
    public State getById(Long id){
        try{
            var state = stateRepository.findById(id);
            if(state.isPresent()){
                return state.get();
            }
            else{
                return null;
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        }

    }

    public State create(State state){
        try{
            state.setInsertionDate(new Date());
            State result = stateRepository.save(state);
            return result;
        } catch(Exception e){
            throw new RuntimeException(e);
        }

    }
    public State update(State state){
        try{
            State existingEntity = getById(state.getId());
            state.setAtualizationDate(new Date());
            state.setInsertionDate(existingEntity.getInsertionDate());

            State result = stateRepository.saveAndFlush(state);
            return result;
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public void delete(Long id){
        try{
            State entity = getById(id);
            stateRepository.delete(entity);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
