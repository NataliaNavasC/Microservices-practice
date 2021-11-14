package com.microsystem.tourismServicesService.Utils.Configuration;

import com.microsystem.tourismServicesService.Service.SearchSoapClient;
import com.microsystem.tourismServicesService.Utils.Constans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class BeansConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath(Constans.SearchSoapClassPackage);
        return marshaller;
    }

    @Bean
    public SearchSoapClient searchSoapClient(Jaxb2Marshaller marshaller) {
        SearchSoapClient client = new SearchSoapClient();
        client.setDefaultUri(Constans.SearchSoapURL);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
