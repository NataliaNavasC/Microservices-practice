package com.microsystem.TouristService.Controllers;

import com.microsystem.TouristService.Model.Tourist;
import com.microsystem.TouristService.Repository.ITouristRepository;
import com.microsystem.TouristService.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
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

    @Autowired
    Environment environment;

    @RequestMapping(
            value = "/status",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String getStatus(){
        String port = environment.getProperty("local.server.port");
        return "Server is up on port " + port;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes =  "application/json" )
    public Tourist createTourist(@RequestBody Tourist newTourist){
        if( newTourist.getName().equals("") ){
            throw new EmptyTouristNameException();
        }
        else if( newTourist.getUsername().equals("") ){
            throw new EmptyTouristUsernameException();
        }
        return repository.save(newTourist);

    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}"
    )
    public Tourist getTouristByID(@PathVariable int id){
        return repository.findById(id).orElseThrow(() -> new TouristNotFoundException(id));        
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
        if(newTourist.getName().equals("")){
            throw new EmptyTouristNameException();
        }
        Tourist tourist = getTouristByID(id);
        tourist.setName(newTourist.getName());
        tourist.setAge(newTourist.getAge());
        tourist.setPhoto(newTourist.getPhoto());
        tourist.setDescription(newTourist.getDescription());
        return repository.save(tourist);
    }

    @RequestMapping (
            method = RequestMethod.DELETE,
            value = "/{username}"
    )
    public void deleteTourist(@PathVariable String username){
        Tourist tourist = repository.findTouristByUsername(username);
        if( tourist != null){
            repository.delete( tourist );
        }        
        else{
            throw new TouristNotFoundException(username);
        }
    }
}
