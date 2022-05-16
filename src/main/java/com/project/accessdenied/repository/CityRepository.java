package com.project.accessdenied.repository;

import com.project.accessdenied.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {
    //List<City> findAllByState(long id);
}
