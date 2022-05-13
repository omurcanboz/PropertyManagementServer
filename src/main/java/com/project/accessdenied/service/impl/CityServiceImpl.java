package com.project.accessdenied.service.impl;

import com.project.accessdenied.entity.City;
import com.project.accessdenied.repository.CityRepository;
import com.project.accessdenied.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City getById(long id) {
        return cityRepository.findById(id);
    }

    @Override
    public float totalIncomeOfCity(long id) {
        return 0;
        //return getById(id).getState().stream().map(s->s.getProperties().stream().filter(p->p.isOccupied()==true).map(p->p.getRentAmount()).reduce(0, (a, b) -> a + b)).reduce(0, (a, b) -> a + b);
    }
}