package com.microsystem.tourismServicesService.Controllers;

import com.microsystem.tourismServicesService.Model.AccomodationService;
import com.microsystem.tourismServicesService.Model.CountryInformation;
import com.microsystem.tourismServicesService.Repository.IAccomodationServiceRepository;
import com.microsystem.tourismServicesService.Utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/services/accomodation")
public class AcommodationServiceController {
    @Autowired
    private Environment environment;

    @Autowired
    private IAccomodationServiceRepository accomodationServiceRepository;
    
    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }


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
    public AccomodationService createService(@RequestBody AccomodationService newService, @RequestParam String origin){
        //Map
        newService.setMapResourceLink(Utils.GATEWAY_URL+"/external/route?origin="+ origin +"&destination="+newService.getLocation());

        //Weather
        LocalDate ldate = newService.getCheckInDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String dateStr = ldate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        newService.setWeatherResourceLink(Utils.GATEWAY_URL+"/external/weather?city=" + newService.getCity() + "&checkInDate="+ dateStr);

        //Country
        CountryInformation countryInformation = restTemplate.getForObject("http://external-service/external/country?destination={destination}", CountryInformation.class, newService.getCountryInformation().getOfficialName());
        newService.setCountryInformation(countryInformation);
        
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
