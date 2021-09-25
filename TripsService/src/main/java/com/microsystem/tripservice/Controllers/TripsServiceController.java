package com.microsystem.tripservice.Controllers;

import com.microsystem.tripservice.Model.Service;
import com.microsystem.tripservice.Repository.ITripServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TripsServiceController {
    @Autowired
    private Environment environment;
    @Autowired
    private ITripServiceRepository tripServiceRepository;

    @RequestMapping(
            value = "/services",
            method = RequestMethod.GET
    )
    public List<Service> getServices(){
        return this.tripServiceRepository.findAll();
    }
    @RequestMapping(
            value = "/services/{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Service getService(@PathVariable int id){
        return this.tripServiceRepository.findById(id).get();
    }
    
    @RequestMapping(
            value = "/services/{category}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<Service> getServicesOfType(@PathVariable String category){
        List<Service> services = new ArrayList<Service>();
        return services; 
    }

    @RequestMapping(
            value = "/services",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Service createService(@RequestBody Service newService){
        return this.tripServiceRepository.save(newService);
    }

    @RequestMapping(
            value = "/services/{id}",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Service updateService(@RequestParam int id,@RequestBody Service updatedService){
        Service serviceToUpdate = this.tripServiceRepository.findById(id).get();
        serviceToUpdate.setTitle(updatedService.getTitle());
        serviceToUpdate.setDescription(updatedService.getDescription());
        serviceToUpdate.setPrice(updatedService.getPrice());
        return this.tripServiceRepository.save(serviceToUpdate);
    }

    @DeleteMapping("/services/{id}")
    public void deleteService(@PathVariable int id){
        this.tripServiceRepository.deleteById(id);
    }
}
