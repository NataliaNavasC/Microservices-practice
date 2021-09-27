package com.microsystem.tourismServicesService.Controllers;

import com.microsystem.tourismServicesService.Model.TransportService;
import com.microsystem.tourismServicesService.Repository.ITransportServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services/transport")
public class TransportServiceController {
    @Autowired
    private Environment environment;

    @Autowired
    private ITransportServiceRepository transportServiceRepository;
    

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
    public List<TransportService> getServices(){
        return this.transportServiceRepository.findAll();
    }
    @RequestMapping(
            value = "{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public TransportService getService(@PathVariable int id){
        return this.transportServiceRepository.findById(id).get();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public TransportService createService(@RequestBody TransportService newService){
        return this.transportServiceRepository.save(newService);
    }

    @RequestMapping(
            value = "{id}",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public TransportService updateService(@RequestParam int id,@RequestBody TransportService updatedService){
        TransportService serviceToUpdate = this.transportServiceRepository.findById(id).get();
        serviceToUpdate.setTitle(updatedService.getTitle());
        serviceToUpdate.setDescription(updatedService.getDescription());
        serviceToUpdate.setPrice(updatedService.getPrice());
        return this.transportServiceRepository.save(serviceToUpdate);
    }

    @DeleteMapping("{id}")
    public void deleteService(@PathVariable int id){
        this.transportServiceRepository.deleteById(id);
    }
}
