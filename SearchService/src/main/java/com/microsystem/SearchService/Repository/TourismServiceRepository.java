package com.microsystem.SearchService.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import services.xsd.TourismService;

public interface TourismServiceRepository extends CrudRepository<TourismService, Integer>{
    
    List<TourismService> findByTitle(String title);
}
