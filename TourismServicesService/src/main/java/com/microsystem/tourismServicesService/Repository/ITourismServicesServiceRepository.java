package com.microsystem.tourismServicesService.Repository;

import com.microsystem.tourismServicesService.Model.TourismService;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ITourismServicesServiceRepository extends CrudRepository<TourismService, Integer> {
    public List<TourismService> findAll();
}
