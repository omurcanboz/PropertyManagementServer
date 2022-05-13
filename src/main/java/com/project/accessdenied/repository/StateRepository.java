package com.project.accessdenied.repository;

import com.project.accessdenied.entity.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepository extends CrudRepository<State, Integer> {

    List<State> findAll();
    State findById(long id);
}
