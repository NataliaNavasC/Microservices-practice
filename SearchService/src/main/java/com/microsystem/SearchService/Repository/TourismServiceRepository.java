package com.microsystem.SearchService.Repository;

import java.util.List;

import com.microsystem.SearchService.Model.TourismService;

import org.springframework.data.repository.CrudRepository;

public interface TourismServiceRepository extends CrudRepository<TourismService, Integer>{
    
    List<TourismService> findByTitleContains(String title);
}
