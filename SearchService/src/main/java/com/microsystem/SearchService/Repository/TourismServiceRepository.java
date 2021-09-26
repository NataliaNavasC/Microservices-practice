package com.microsystem.SearchService.Repository;

import java.util.List;

import com.microsystem.SearchService.Model.TourismServiceEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TourismServiceRepository extends CrudRepository<TourismServiceEntity, Integer>{
    
    @Query("SELECT s FROM Tourism_Service s WHERE s.title like :title")
    List<TourismServiceEntity> findByTitle(String title);
}
