package com.microsystem.ExternalServices.Controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.maps.*;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.TravelMode;
import com.microsystem.ExternalServices.Model.CountryInformation;
import com.microsystem.ExternalServices.Model.Steps;
import com.microsystem.ExternalServices.Model.Weather;
import com.microsystem.ExternalServices.Utils.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.MediaType;
import java.util.*;

@RestController
public class ExternalController {

    @Autowired
    Environment environment;

    @Autowired
    RestTemplate restTemplate;

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RequestMapping(
            value = "/status",
            produces = MediaType.APPLICATION_JSON
    )
    public String getStatus(){
        String port = environment.getProperty("server.port");
        return "Server is up on port " + port;
    }

    @GetMapping("/route")
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

    @GetMapping("/country")
    public ResponseEntity getDestinationInfo(@RequestParam String destination){
        String restCountriesUrl  = "https://restcountries.com/v3.1/name";
        ResponseEntity<String> response = restTemplate.getForEntity(restCountriesUrl + "/"+destination, String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response.getBody());
            CountryInformation countryInformation = new CountryInformation(root.get(0));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(countryInformation);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/weather")
    public ResponseEntity getWeatherInfo(@RequestParam String city,@RequestParam String checkInDate){
        String key = "280543ca0f464683a7d202458211311";
        String APIresponse = restTemplate.getForObject("http://api.weatherapi.com/v1/forecast.json?key={key}&q={city}&days=10&aqi=no&alerts=no", String.class, key, city);
        try {
            Weather weather = Utils.convertJsontoWeather(APIresponse,checkInDate);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(weather);
        } 
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    // ----------------------------------------------------------------------------

    

}
