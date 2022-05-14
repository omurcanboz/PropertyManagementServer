package com.project.accessdenied.repository;

import com.project.accessdenied.entity.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {

    //display top 10 order by last rented date desc
    List<Property> findTop10ByOrderByLastRentedDateDesc();
    //List<Property> findAllByOccupiedIs(Boolean b);
    //List<Property> findAllByNumberOfBedroomsIsGreaterThanEqual(int rn);
    //List<Property> findAllByCity(City c);
    //List<Property> findAllByState(State s);
    /*
    admin-Display the last 10 properties rented.
    landlord-Display 10 properties whose leases end in a month.
     */

}
