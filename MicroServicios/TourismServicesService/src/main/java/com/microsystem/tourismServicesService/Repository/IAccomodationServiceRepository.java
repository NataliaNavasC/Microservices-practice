package com.microsystem.tourismServicesService.Repository;

import com.microsystem.tourismServicesService.Model.AccomodationService;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IAccomodationServiceRepository extends CrudRepository<AccomodationService, Integer>{
    public List<AccomodationService> findAll();
}
