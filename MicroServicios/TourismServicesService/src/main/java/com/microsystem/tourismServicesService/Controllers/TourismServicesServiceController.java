package com.microsystem.tourismServicesService.Controllers;

import com.microsystem.tourismServicesService.Model.TourismService;
import com.microsystem.tourismServicesService.Repository.ITourismServiceRepository;
import com.microsystem.tourismServicesService.Service.SearchSoapClient;
import com.microsystem.tourismServicesService.stub.TourismServiceSOAP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "")
public class TourismServicesServiceController{
    @Autowired
    private Environment environment;

    @Autowired
    private ITourismServiceRepository tourismServiceRepository;

    @Autowired
    private SearchSoapClient searchSoapClient;
    

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
    public List<TourismService> getServices(){
        return this.tourismServiceRepository.findAll();
    }
    @RequestMapping(
            value = "{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public TourismService getService(@PathVariable int id){
        return this.tourismServiceRepository.findById(id).get();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public TourismService createService(@RequestBody TourismService newService){
        return this.tourismServiceRepository.save(newService);
    }

    @RequestMapping(
            value = "{id}",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public TourismService updateService(@PathVariable int id,@RequestBody TourismService updatedService){
        TourismService serviceToUpdate = this.tourismServiceRepository.findById(id).get();
        serviceToUpdate.setTitle(updatedService.getTitle());
        serviceToUpdate.setDescription(updatedService.getDescription());
        serviceToUpdate.setPrice(updatedService.getPrice());
        serviceToUpdate.setItems(updatedService.getItems());
        return this.tourismServiceRepository.save(serviceToUpdate);
    }

    @RequestMapping(
            value = "/provider/{providerId}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<TourismService> getServicesByProviderId(@PathVariable int providerId){
        return this.tourismServiceRepository.findByProviderId(providerId);
    }

    @RequestMapping(
            value = "/search",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public List<TourismServiceSOAP> searchServices(@RequestParam String title){
        return searchSoapClient.searchServices(title);
    } 

    @DeleteMapping("{id}")
    public void deleteService(@PathVariable int id){
        this.tourismServiceRepository.deleteById(id);
    }
}
