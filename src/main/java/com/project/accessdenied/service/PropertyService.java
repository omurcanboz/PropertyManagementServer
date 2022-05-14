package com.project.accessdenied.service;

import com.project.accessdenied.entity.Property;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PropertyService {
    void save(Property p);
    void deleteById(long id);
    List<Property> getAll();
    Property getById(long id);
    List<Property> getAllByOccupiedIs(boolean b);
    List<Property> getAllByNumberOfBedroomsIsGreaterThanEqual(int roomNum);
    List<Property> getAllByCity(long id);
    List<Property> getAllByState(long id);
    //admin
    List<Property> getLastTenRented();
    //landlord
    List<Property> getLeaseEndComing();

}
