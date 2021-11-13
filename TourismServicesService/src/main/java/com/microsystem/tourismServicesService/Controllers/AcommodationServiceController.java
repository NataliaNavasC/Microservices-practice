package com.microsystem.tourismServicesService.Controllers;

import com.microsystem.tourismServicesService.Model.AccomodationService;
import com.microsystem.tourismServicesService.Repository.IAccomodationServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tourism-services/accomodation")
public class AcommodationServiceController {
    @Autowired
    private Environment environment;

    @Autowired
    private IAccomodationServiceRepository accomodationServiceRepository;
    

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
    public List<AccomodationService> getServices(){
        return this.accomodationServiceRepository.findAll();
    }
    @RequestMapping(
            value = "{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public AccomodationService getService(@PathVariable int id){
        return this.accomodationServiceRepository.findById(id).get();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public AccomodationService createService(@RequestBody AccomodationService newService){
        return this.accomodationServiceRepository.save(newService);
    }

    @RequestMapping(
            value = "{id}",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public AccomodationService updateService(@PathVariable int id,@RequestBody AccomodationService updatedService){
        AccomodationService serviceToUpdate = this.accomodationServiceRepository.findById(id).get();
        serviceToUpdate.setTitle(updatedService.getTitle());
        serviceToUpdate.setDescription(updatedService.getDescription());
        serviceToUpdate.setPrice(updatedService.getPrice());
        serviceToUpdate.setItems(updatedService.getItems());
        return this.accomodationServiceRepository.save(serviceToUpdate);
    }

    @DeleteMapping("{id}")
    public void deleteService(@PathVariable int id){
        this.accomodationServiceRepository.deleteById(id);
    }
}
