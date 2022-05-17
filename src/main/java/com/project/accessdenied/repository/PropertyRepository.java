package com.project.accessdenied.repository;

import com.project.accessdenied.entity.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Long> {

    //display top 10 order by last rented date desc
    List<Property> findTop10ByIsOccupiedEqualsOrderByLastRentedDateDesc(Boolean val);
    List<Property> findAllByIsOccupiedEqualsAndCity_IdEquals(boolean val, long id);
    List<Property> findAllByIsOccupiedEqualsAndEndDateGreaterThanAndEndDateLessThan(boolean val, LocalDate today, LocalDate nextMonth);
    List<Property> findAllByOwnedBy_IdEquals(long id);
    List<Property> findAllByLastRentedDateGreaterThanAndLastRentedDateLessThan(LocalDate lastWeek, LocalDate today);
    //List<Property> findAllByOccupiedIs(Boolean b);
    //List<Property> findAllByNumberOfBedroomsIsGreaterThanEqual(int rn);
    //List<Property> findAllByCity(City c);
    //List<Property> findAllByState(State s);
    /*
    admin-Display the last 10 properties rented.
    landlord-Display 10 properties whose leases end in a month.
     */

}
