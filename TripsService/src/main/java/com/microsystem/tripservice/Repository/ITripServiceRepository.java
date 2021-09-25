package com.microsystem.tripservice.Repository;

import com.microsystem.tripservice.Model.Service;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ITripServiceRepository extends CrudRepository<Service, Integer> {
    public List<Service> findAll();
}
