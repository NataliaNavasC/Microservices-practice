package com.microsystem.ExternalServices.Controllers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.*;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;
import com.microsystem.ExternalServices.Model.Steps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ExternalController {

    @Autowired
    Environment environment;


    @RequestMapping(
            value = "/external/status",
            produces = MediaType.APPLICATION_JSON
    )
    public String getStatus(){
        String port = environment.getProperty("local.server.port");
        return "Server is up on port " + port;
    }

    @GetMapping("/external")
    public ResponseEntity getRoute(@RequestParam String origin, @RequestParam String destination){
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyDas7ktt6ipyaGAozPOS9-w58k5FsEXpN0")
                .build();
        try {
            DirectionsResult results = DirectionsApi.getDirections(context,origin,destination).mode(TravelMode.DRIVING).await();
            List<Steps> steps =  new ArrayList<>();
            Arrays.stream(results.routes[0].legs[0].steps).forEach(step -> steps.add(new Steps(step)));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(steps);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
