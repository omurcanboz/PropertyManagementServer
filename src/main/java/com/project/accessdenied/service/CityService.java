package com.project.accessdenied.service;

import com.project.accessdenied.entity.City;

import java.util.List;

public interface CityService {
    public List<City> getAll();
    public City getById(int id);
    int totalIncomeOfCity(int id);
}
