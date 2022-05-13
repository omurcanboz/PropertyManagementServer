package com.project.accessdenied.repository;

import com.project.accessdenied.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {

    List<City> findAll();
    City findById(long id);

}
