package com.project.accessdenied.repository;

import com.project.accessdenied.entity.City;
import com.project.accessdenied.entity.Property;
import com.project.accessdenied.entity.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Integer> {

    List<Property> findAll();
    Property findById(long id);
    void deleteById(long id);
    //List<Property> findAllByOccupiedIs(Boolean b);
    //List<Property> findAllByNumberOfBedroomsIsGreaterThanEqual(int rn);
    //List<Property> findAllByCity(City c);
    //List<Property> findAllByState(State s);
    /*
    admin-Display the last 10 properties rented.
    landlord-Display 10 properties whose leases end in a month.
     */

}
