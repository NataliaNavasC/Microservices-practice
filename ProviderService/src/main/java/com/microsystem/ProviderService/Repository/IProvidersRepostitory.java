package com.microsystem.ProviderService.Repository;

import java.util.Optional;

import com.microsystem.ProviderService.Model.Provider;
import org.springframework.data.repository.CrudRepository;

public interface IProvidersRepostitory extends CrudRepository<Provider, Integer> {

    public Optional<Provider> findProviderByUsername(String username);
}
