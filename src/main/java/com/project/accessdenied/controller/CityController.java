package com.project.accessdenied.controller;

import com.project.accessdenied.entity.City;
import com.project.accessdenied.service.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cities")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getAll() {
        return cityService.getAll();
    }

    @GetMapping("/{id}")
    public City getById(@PathVariable long id) {
        return cityService.getById(id);
    }

    @GetMapping("/state/{id}")
    public List<City> getAllByState(@PathVariable long id) {
        return cityService.getByState(id);
    }
}
