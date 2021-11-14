package com.microsystem.tourismServicesService.Repository;

import java.util.List;

import com.microsystem.tourismServicesService.Model.TourismService;

import org.springframework.data.repository.CrudRepository;

public interface ITourismServiceRepository extends CrudRepository<TourismService,Integer> {
    public List<TourismService> findAll();
    public List<TourismService> findByProviderId(int id);
}