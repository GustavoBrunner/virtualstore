package com.dev.backend.contracts;

import java.util.List;

import com.dev.backend.entities.City;

public interface CityService {
    public City create(City city);
    public List<City> getAll();
    public City getById(Long id);
    public City update(City city);
    public void delete(Long id);
}
