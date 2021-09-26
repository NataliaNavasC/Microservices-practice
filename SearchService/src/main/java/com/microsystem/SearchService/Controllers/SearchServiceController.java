package com.microsystem.SearchService.Controllers;

import java.util.List;

import com.microsystem.SearchService.Repository.TourismServiceRepository;
import com.netflix.discovery.converters.Auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import services.xsd.ObjectFactory;
import services.xsd.SearchServiceRequest;
import services.xsd.TourismService;
import services.xsd.TourismServiceReponse;

@Endpoint
public class SearchServiceController {
    
    private static final String NAMESPACE_URI = "http://services/xsd/";
    private ObjectFactory factory;

    @Autowired
    private TourismServiceRepository repository;

    @Autowired
	public SearchServiceController() {
		this.factory = new ObjectFactory();
	}
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SearchService")
    @ResponsePayload
    public TourismServiceReponse SearchService(@RequestPayload SearchServiceRequest searchServiceRequest){
        List<TourismService> servicesFound  = new ArrayList<TourismService>();
        if(searchServiceRequest.getSearchType() == "title"){
            this.repository.findByTitle(searchServiceRequest.getParameter()).forEach(servicesFound::add);
        }

        else if(searchServiceRequest.getSearchType() == "type"){
            List<TourismService> aux = new ArrayList<TourismService>();
            this.repository.findAll().forEach(aux::add);
            for (TourismService tourismService : aux) {
                if(aux instanceof  )
            }
            servicesFound.forEach(this.repository.findByType());
        }
        
        TourismService service = factory.createTourismService();
        TourismServiceReponse response = factory.createTourismServiceReponse();
        response.getService().forEach(servicesFound::add);
        return response;
    }
}
