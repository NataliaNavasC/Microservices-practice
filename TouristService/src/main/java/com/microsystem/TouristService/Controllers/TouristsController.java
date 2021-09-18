package com.microsystem.TouristService.Controllers;

import com.microsystem.TouristService.Model.Tourist;
import com.microsystem.TouristService.Repository.ITouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(
        value = "/tourists",
        produces =  "application/json"
)
public class TouristsController {

    @Autowired
    private ITouristRepository repository;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes =  "application/json" )
    public Tourist createTourist(@RequestBody Tourist newTourist){
        return repository.save(newTourist);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}"
    )
    public Tourist getTouristByID(@PathVariable int id){
        return repository.findById(id).get();
    }

    @RequestMapping( method = RequestMethod.GET )
    public List<Tourist> getAllTourist(){
        List<Tourist> tourists = new ArrayList<Tourist>();
        repository.findAll().forEach(tourists::add);
        return tourists;
    }

    @RequestMapping (
            method = RequestMethod.PUT,
            value = "/{id}",
            consumes =  "application/json"
    )
    public Tourist updateTourist(@RequestBody Tourist newTourist, @PathVariable int id){
        Tourist tourist = getTouristByID(id);
        tourist.setName(newTourist.getName());
        tourist.setAge(newTourist.getAge());
        tourist.setPhoto(newTourist.getPhoto());
        return repository.save(tourist);
    }

    @RequestMapping (
            method = RequestMethod.DELETE,
            value = "/{id}"
    )
    public void deleteTourist(@PathVariable int id){
        repository.deleteById(id);
    }
}
