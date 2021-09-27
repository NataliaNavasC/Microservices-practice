package com.microsystem.tourismServicesService.Controllers;

import com.microsystem.tourismServicesService.Model.TourismService;
import com.microsystem.tourismServicesService.Repository.ITourismServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "services")
public class TourismServicesServiceController {
    @Autowired
    private Environment environment;

    @Autowired
    private ITourismServiceRepository tourismServiceRepository;
    

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
    public TourismService updateService(@RequestParam int id,@RequestBody TourismService updatedService){
        TourismService serviceToUpdate = this.tourismServiceRepository.findById(id).get();
        serviceToUpdate.setTitle(updatedService.getTitle());
        serviceToUpdate.setDescription(updatedService.getDescription());
        serviceToUpdate.setPrice(updatedService.getPrice());
        return this.tourismServiceRepository.save(serviceToUpdate);
    }

    @DeleteMapping("{id}")
    public void deleteService(@PathVariable int id){
        this.tourismServiceRepository.deleteById(id);
    }
}