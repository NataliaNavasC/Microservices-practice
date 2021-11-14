package com.microsystem.tourismServicesService.Repository;

import com.microsystem.tourismServicesService.Model.TransportService;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ITransportServiceRepository extends CrudRepository<TransportService, Integer>{
    public List<TransportService> findAll();
}
