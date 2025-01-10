package com.dev.backend.services.contracts;

import java.util.List;

import com.dev.backend.entities.State;

public interface StateService {
    public State create(State entity);
    public State update(State entity);
    public State getById(Long id);
    public List<State> getAll();
    public void delete(Long id);
}
