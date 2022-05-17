package com.project.accessdenied.controller;

import com.project.accessdenied.dto.PropertyDto;
import com.project.accessdenied.dto.RentedDto;
import com.project.accessdenied.entity.Property;
import com.project.accessdenied.service.PropertyService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
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

    //ADMIN
    @GetMapping("/incomes/city/{id}")
    public float getTotalIncomePerCityLocation(@PathVariable long id) {
        return propertyService.getTotalIncomePerLocation(id);
    }

    @GetMapping("/incomes/user/{id}")
    public List<PropertyDto> getTotalIncomePerUser(@PathVariable long id) {
        return propertyService.getTotalIncomePerUser(id);
    }

    @GetMapping("/leases")
    public List<Property> getTenPropertiesEndInMonth(){

        LocalDate today = LocalDate.now();

        LocalDate newDate = today.plusMonths(1);

        return propertyService.getLeases(today, newDate);

    }

    @GetMapping("/num-of-properties")
    public List<RentedDto> getLastWeekRented() {
        return propertyService.getLastWeekRented();
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
