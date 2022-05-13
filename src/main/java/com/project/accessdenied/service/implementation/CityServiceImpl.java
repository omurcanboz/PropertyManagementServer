package com.project.accessdenied.service.implementation;

import com.project.accessdenied.entity.City;
import com.project.accessdenied.entity.Property;
import com.project.accessdenied.repo.CityRepo;
import com.project.accessdenied.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepo cityRepo;

    @Override
    public List<City> getAll() {
        return cityRepo.findAll();
    }

    @Override
    public City getById(int id) {
        City c= new City();
        cityRepo.findById(id).ifPresentOrElse(
                value -> {
                    c.setId(value.getId());
                    c.setName(value.getName());
                    c.setStates(value.getStates());
                },
                () -> { //default city when not found
                    c.setId(0);
                    c.setName("xx");
                    c.setStates(null);
                }
        );
        return c;
    }

    @Override
    public int totalIncomeOfCity(int id) {
        return getById(id).getStates().stream().map(s->s.getProperties().stream().filter(p->p.isOccupied()==true).map(p->p.getRentAmount()).reduce(0, (a, b) -> a + b)).reduce(0, (a, b) -> a + b);
    }
}
