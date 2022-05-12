package com.project.accessdenied.repo;

import com.waa.PropertyManagementServer.entity.Property;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepo extends CrudRepository<Property, Integer> {
}
