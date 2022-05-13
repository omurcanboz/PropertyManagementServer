package com.project.accessdenied.service.implementation;

import com.project.accessdenied.entity.State;
import com.project.accessdenied.repo.StateRepo;
import com.project.accessdenied.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements StateService {
    private final StateRepo stateRepo;

    @Override
    public List<State> getAll() {
        return stateRepo.findAll();
    }

    @Override
    public State getById(int id) {
        State s= new State();
        stateRepo.findById(id).ifPresentOrElse(
                value -> {
                    s.setId(value.getId());
                    s.setName(value.getName());
                    s.setCity(value.getCity());
                    s.setProperties(value.getProperties());
                },
                () -> { //default city when not found
                    s.setId(0);
                    s.setName("xx");
                    s.setCity(null);
                    s.setProperties(null);
                }
        );
        return s;
    }

    @Override
    public int totalIncomeOfState(int id) {
        State s=getById(id);
        return s.getProperties().stream().filter(p->p.isOccupied()==true).map(p->p.getRentAmount()).reduce(0, (a, b) -> a + b);
    }
}
