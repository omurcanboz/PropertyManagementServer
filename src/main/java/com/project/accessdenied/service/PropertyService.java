package com.project.accessdenied.service;

import com.project.accessdenied.entity.City;
import com.project.accessdenied.entity.Property;
import com.project.accessdenied.entity.State;

import java.util.List;

public interface PropertyService {
    Property save(Property p);
    void deleteById(int id);
    List<Property> getAll();
    Property getById(int id);
    List<Property> getAllByOccupiedIs(Boolean b);
    List<Property> getAllByNumberOfBedroomsIsGreaterThanEqual(int rn);
    List<Property> getAllByCity(int id);
    List<Property> getAllByState(int id);
    //admin
    List<Property> getLastTenRented();
    //landlord
    List<Property> getLeaseEndComing();

}
