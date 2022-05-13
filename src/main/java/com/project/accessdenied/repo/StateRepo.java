package com.project.accessdenied.repo;

import com.project.accessdenied.entity.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepo extends CrudRepository<State, Integer> {
    @Override
    List<State> findAll();

    @Override
    Optional<State> findById(Integer integer);
}
