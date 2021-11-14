package com.microsystem.ProviderService.Repository;

import com.microsystem.ProviderService.Model.Provider;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IProvidersRepostitory extends CrudRepository<Provider, Integer> {

    public Optional<Provider> findProviderByUsername(String username);
}
