package com.microsystem.tourismServicesService.Service;

import java.util.List;

import com.microsystem.tourismServicesService.Utils.Constans;
import com.microsystem.tourismServicesService.stub.GetSearchRequest;
import com.microsystem.tourismServicesService.stub.GetSearchResponse;
import com.microsystem.tourismServicesService.stub.TourismServiceSOAP;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class SearchSoapClient  extends WebServiceGatewaySupport  {
    public List<TourismServiceSOAP> searchServices(String title){
        GetSearchRequest searchRequest = new GetSearchRequest();
        searchRequest.setTitle(title);
        GetSearchResponse searchResponse = (GetSearchResponse) getWebServiceTemplate()
        .marshalSendAndReceive(Constans.SearchSoapURL, searchRequest,
            new SoapActionCallback(
                Constans.SearchSoapURL));
        return searchResponse.getService();
    }
}
