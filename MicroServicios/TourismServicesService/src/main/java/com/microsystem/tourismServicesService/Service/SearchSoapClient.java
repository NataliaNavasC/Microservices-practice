package com.microsystem.tourismServicesService.Service;

import java.util.List;

import com.microsystem.tourismServicesService.Utils.Constans;
import com.microsystem.tourismServicesService.stub.GetSearchRequest;
import com.microsystem.tourismServicesService.stub.GetSearchResponse;
import com.microsystem.tourismServicesService.stub.TourismServiceSOAP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class SearchSoapClient  extends WebServiceGatewaySupport  {
    
    @Autowired
    Environment env;

    public List<TourismServiceSOAP> searchServices(String title){
        GetSearchRequest searchRequest = new GetSearchRequest();
        searchRequest.setTitle(title);
        GetSearchResponse searchResponse = (GetSearchResponse) getWebServiceTemplate()
        .marshalSendAndReceive(env.getProperty("soap.url") , searchRequest,
            new SoapActionCallback(
                env.getProperty("soap.url")));
        return searchResponse.getService();
    }
}
