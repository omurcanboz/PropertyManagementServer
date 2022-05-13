package com.project.accessdenied.service;

import com.project.accessdenied.entity.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CityService {
    List<City> getAll();
    City getById(long id);
    float totalIncomeOfCity(long id);
}
