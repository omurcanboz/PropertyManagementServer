package com.project.accessdenied.service.impl;

import com.project.accessdenied.entity.City;
import com.project.accessdenied.entity.Property;
import com.project.accessdenied.entity.State;
import com.project.accessdenied.repository.PropertyRepository;
import com.project.accessdenied.service.PropertyService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }


    @Override
    public void save(Property p) {
        propertyRepository.save(p);
    }

    @Override
    public void deleteById(long id) {
        propertyRepository.deleteById(id);
    }

    @Override
    public List<Property> getAll() {
        return propertyRepository.findAll();
    }

    @Override
    public Property getById(long id) {
        return propertyRepository.findById(id);
    }

    @Override
    public List<Property> getAllByOccupiedIs(boolean b) {
        return null;
        //return propertyRepository.findAllByOccupiedIs(true);
    }

    @Override
    public List<Property> getAllByNumberOfBedroomsIsGreaterThanEqual(int rn) {
       return null;
        // return propertyRepository.findAllByNumberOfBedroomsIsGreaterThanEqual(rn);
    }

    @Override
    public List<Property> getAllByCity(long id) {
        return null;
        //City c=cityService.getById(id);
       // return propertyRepository.findAllByCity(c);
    }

    @Override
    public List<Property> getAllByState(long id) {
        return  null;
       // State s= stateService.getById(id);
       // return propertyRepository.findAllByState(s);
    }

    @Override
    public List<Property> getLastTenRented() {
        LocalDate now= LocalDate.now();
        return propertyRepository.findAll().stream().sorted(new Comparator<Property>() {
            @Override
            public int compare(Property o1, Property o2) {
                LocalDate o1min=o1.getRentPeriods().stream().map(rp->rp.getRentedAt()).min(Comparator.comparingLong(date -> ChronoUnit.DAYS.between(now , date))).orElse(LocalDate.of(1900, 1, 1));
                LocalDate o2min=o2.getRentPeriods().stream().map(rp->rp.getRentedAt()).min(Comparator.comparingLong(date -> ChronoUnit.DAYS.between(now , date))).orElse(LocalDate.of(1900, 1, 1));

                return (int) ChronoUnit.DAYS.between(o1min , o2min);
            }
        }).limit(10).collect(Collectors.toList());

    }

    @Override
    public List<Property> getLeaseEndComing() {
        LocalDate endOfMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        return propertyRepository.findAll().stream().sorted(new Comparator<Property>() {
            @Override
            public int compare(Property o1, Property o2) {
                LocalDate o1min=o1.getRentPeriods().stream().map(rp->rp.getRentedAt()).min(Comparator.comparingLong(date -> ChronoUnit.DAYS.between(endOfMonth , date))).orElse(LocalDate.of(1900, 1, 1));
                LocalDate o2min=o2.getRentPeriods().stream().map(rp->rp.getRentedAt()).min(Comparator.comparingLong(date -> ChronoUnit.DAYS.between(endOfMonth , date))).orElse(LocalDate.of(1900, 1, 1));

                return (int) ChronoUnit.DAYS.between(o1min , o2min);
            }
        }).limit(10).collect(Collectors.toList());
    }
}
