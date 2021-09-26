package com.microsystem.tourismServicesService.Controllers;

import com.microsystem.tourismServicesService.Model.FoodService;
import com.microsystem.tourismServicesService.Repository.IFoodServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services/food")
public class FoodServiceController {
    @Autowired
    private Environment environment;

    @Autowired
    private IFoodServiceRepository foodServiceRepository;
    

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
    public List<FoodService> getServices(){
        return this.foodServiceRepository.findAll();
    }
    @RequestMapping(
            value = "{id}",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public FoodService getService(@PathVariable int id){
        return this.foodServiceRepository.findById(id).get();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public FoodService createService(@RequestBody FoodService newService){
        return this.foodServiceRepository.save(newService);
    }

    @RequestMapping(
            value = "{id}",
            method = RequestMethod.PUT,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public FoodService updateService(@RequestParam int id,@RequestBody FoodService updatedService){
        FoodService serviceToUpdate = this.foodServiceRepository.findById(id).get();
        serviceToUpdate.setTitle(updatedService.getTitle());
        serviceToUpdate.setDescription(updatedService.getDescription());
        serviceToUpdate.setPrice(updatedService.getPrice());
        return this.foodServiceRepository.save(serviceToUpdate);
    }

    @DeleteMapping("{id}")
    public void deleteService(@PathVariable int id){
        this.foodServiceRepository.deleteById(id);
    }
}
