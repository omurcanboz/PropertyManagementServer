package com.project.accessdenied.service;

import com.project.accessdenied.entity.State;

import java.util.List;

public interface StateService {
    public List<State> getAll();
    State getById(int id);
    int totalIncomeOfState(int id);

}
