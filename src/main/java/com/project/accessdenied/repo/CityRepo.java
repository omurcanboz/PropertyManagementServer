package com.project.accessdenied.repo;

import com.project.accessdenied.entity.City;
import com.project.accessdenied.entity.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepo extends CrudRepository<City, Integer> {
    @Override
    List<City> findAll();

    @Override
    Optional<City> findById(Integer integer);

}
