package com.project.accessdenied.repo;

import com.project.accessdenied.entity.City;
import com.project.accessdenied.entity.Property;
import com.project.accessdenied.entity.RentPeriod;
import com.project.accessdenied.entity.State;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepo extends CrudRepository<Property, Integer> {
    @Override
    Property save(Property p);
    @Override
    List<Property> findAll();
    @Override
    Optional<Property> findById(Integer integer);
    @Override
    void deleteById(Integer integer);
    List<Property> findAllByOccupiedIs(Boolean b);
    List<Property> findAllByNumberOfBedroomsIsGreaterThanEqual(int rn);
    List<Property> findAllByCity(City c);
    List<Property> findAllByState(State s);
    /*
    admin-Display the last 10 properties rented.
    landlord-Display 10 properties whose leases end in a month.
     */

}
