package com.microsystem.tourismServicesService.Repository;

import com.microsystem.tourismServicesService.Model.EcoTripService;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IEcoTripServiceRepository extends CrudRepository<EcoTripService, Integer> {
    public List<EcoTripService> findAll();
}
