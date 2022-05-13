package com.project.accessdenied.service.implementation;

import com.project.accessdenied.entity.City;
import com.project.accessdenied.entity.Property;
import com.project.accessdenied.entity.State;
import com.project.accessdenied.repo.PropertyRepo;
import com.project.accessdenied.service.CityService;
import com.project.accessdenied.service.PropertyService;
import com.project.accessdenied.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepo propertyRepo;
    private final CityService cityService;
    private final StateService stateService;

    @Override
    public Property save(Property p) {
        return propertyRepo.save(p);
    }

    @Override
    public void deleteById(int id) {
        propertyRepo.deleteById(id);
    }

    @Override
    public List<Property> getAll() {
        return propertyRepo.findAll();
    }

    @Override
    public Property getById(int id) {
        Property p=new Property();
        propertyRepo.findById(id).ifPresentOrElse(
                value -> {
                    p.setId(value.getId());
                    p.setName(value.getName());
                    p.setCity(value.getCity());
                    p.setLastRentedBy(value.getLastRentedBy());
                    p.setOccupied(value.isOccupied());
                    p.setNumberOfBathrooms(value.getNumberOfBathrooms());
                    p.setNumberOfBedrooms(value.getNumberOfBedrooms());
                    p.setRentAmount(value.getRentAmount());
                    p.setPhotos(value.getPhotos());
                    p.setSecurityDepositAmount(value.getSecurityDepositAmount());
                    p.setOwnedBy(value.getOwnedBy());
                    p.setRentPeriods(value.getRentPeriods());
                    p.setState(value.getState());
                },
                () -> { //default city when not found
                    p.setId(0);
                }
        );
        return p;
    }

    @Override
    public List<Property> getAllByOccupiedIs(Boolean b) {
        return propertyRepo.findAllByOccupiedIs(true);
    }

    @Override
    public List<Property> getAllByNumberOfBedroomsIsGreaterThanEqual(int rn) {
        return propertyRepo.findAllByNumberOfBedroomsIsGreaterThanEqual(rn);
    }

    @Override
    public List<Property> getAllByCity(int id) {
        City c=cityService.getById(id);
        return propertyRepo.findAllByCity(c);
    }

    @Override
    public List<Property> getAllByState(int id) {
        State s= stateService.getById(id);
        return propertyRepo.findAllByState(s);
    }

    @Override
    public List<Property> getLastTenRented() {
        LocalDate now= LocalDate.now();
        return propertyRepo.findAll().stream().sorted(new Comparator<Property>() {
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
        return propertyRepo.findAll().stream().sorted(new Comparator<Property>() {
            @Override
            public int compare(Property o1, Property o2) {
                LocalDate o1min=o1.getRentPeriods().stream().map(rp->rp.getRentedAt()).min(Comparator.comparingLong(date -> ChronoUnit.DAYS.between(endOfMonth , date))).orElse(LocalDate.of(1900, 1, 1));
                LocalDate o2min=o2.getRentPeriods().stream().map(rp->rp.getRentedAt()).min(Comparator.comparingLong(date -> ChronoUnit.DAYS.between(endOfMonth , date))).orElse(LocalDate.of(1900, 1, 1));

                return (int) ChronoUnit.DAYS.between(o1min , o2min);
            }
        }).limit(10).collect(Collectors.toList());
    }
}
