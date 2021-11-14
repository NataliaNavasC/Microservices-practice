package com.microsystem.tourismServicesService.Controllers;

import com.microsystem.tourismServicesService.Model.EcoTripService;
import com.microsystem.tourismServicesService.Repository.IEcoTripServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ecoTrip")
public class EcoTripServiceController {
    @Autowired
    private Environment environment;

    @Autowired
    private IEcoTripServiceRepository ecoTripServiceRepository;
    

    @RequestMapping(
            value = "/status",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String getStatus(){
        String port = environment.getProperty("local.server.port");
        return "Server is up on port " + port;
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<EcoTripService> getServices(){
        return this.ecoTripServiceRepository.findAll();
    }
    @RequestMapping(
            value = "{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public EcoTripService getService(@PathVariable int id){
        return this.ecoTripServiceRepository.findById(id).get();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public EcoTripService createService(@RequestBody EcoTripService newService){
        return this.ecoTripServiceRepository.save(newService);
    }

    @RequestMapping(
            value = "{id}",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public EcoTripService updateService(@PathVariable int id,@RequestBody EcoTripService updatedService){
        EcoTripService serviceToUpdate = this.ecoTripServiceRepository.findById(id).get();
        serviceToUpdate.setTitle(updatedService.getTitle());
        serviceToUpdate.setDescription(updatedService.getDescription());
        serviceToUpdate.setPrice(updatedService.getPrice());
        serviceToUpdate.setHasGuide(updatedService.isHasGuide());
        serviceToUpdate.setItems(updatedService.getItems());
        return this.ecoTripServiceRepository.save(serviceToUpdate);
    }

    @DeleteMapping("{id}")
    public void deleteService(@PathVariable int id){
        this.ecoTripServiceRepository.deleteById(id);
    }
}
