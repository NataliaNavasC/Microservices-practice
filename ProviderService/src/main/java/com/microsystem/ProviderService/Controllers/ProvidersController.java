package com.microsystem.ProviderService.Controllers;

import com.microsystem.ProviderService.Model.Provider;
import com.microsystem.ProviderService.Repository.IProvidersRepostitory;
import com.microsystem.ProviderService.Request.ProviderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;


@RestController
public class ProvidersController {
    @Autowired
    private IProvidersRepostitory providersRepostitory;

    @PostMapping("/providers")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity createProvider(@RequestBody ProviderRequest providerRequest){
        //TODO: Hacer Validaciones
        Provider provider = new Provider(providerRequest.getPhoneNumber(),providerRequest.getWebPage(),providerRequest.getSocialNetwork());
        providersRepostitory.save(provider);
        //TODO: Si hay problemas, atrapar exception y enviar el body el contextyo
        return ResponseEntity.status(HttpStatus.CREATED).body("Creado Correctamente");
    }

    @GetMapping("/providers")
    public ResponseEntity getProviders(){
        List<Provider> providers = new ArrayList<>();
        providersRepostitory.findAll().forEach(provider -> providers.add(provider));
        return ResponseEntity.status(HttpStatus.FOUND).body(providers);
    }
}
