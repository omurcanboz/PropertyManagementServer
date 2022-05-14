package com.project.accessdenied.controller;

import com.project.accessdenied.entity.Property;
import com.project.accessdenied.service.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {
    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public List<Property> getAll() {
        return propertyService.getAll();
    }

    @GetMapping("/{id}")
    public Property getById(@PathVariable long id) {
        return propertyService.getById(id);
    }

    @GetMapping("/lastten")
    public List<Property> getLastTenProperties() {
        return propertyService.getLastTenRented();
    }

    @PostMapping
    public void save(@RequestBody Property property) {
        propertyService.save(property);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        propertyService.deleteById(id);
    }
}
