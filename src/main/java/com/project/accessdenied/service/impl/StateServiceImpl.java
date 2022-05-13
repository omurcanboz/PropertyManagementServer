package com.project.accessdenied.service.impl;

import com.project.accessdenied.entity.State;
import com.project.accessdenied.repository.StateRepository;
import com.project.accessdenied.service.StateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {
    private final StateRepository stateRepository;

    public StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public List<State> getAll() {
        return stateRepository.findAll();
    }

    @Override
    public State getById(long id) {
        return stateRepository.findById(id);
    }

    @Override
    public float totalIncomeOfState(long id) {
        //State s=getById(id);
        return 0;
        //return s.getProperties().stream().filter(p->p.isOccupied()==true).map(p->p.getRentAmount()).reduce(0, (a, b) -> a + b);
    }
}
