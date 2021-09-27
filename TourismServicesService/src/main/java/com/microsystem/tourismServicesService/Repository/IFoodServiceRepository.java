package com.microsystem.tourismServicesService.Repository;

import com.microsystem.tourismServicesService.Model.FoodService;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IFoodServiceRepository extends CrudRepository<FoodService, Integer>{
    public List<FoodService> findAll();
}
