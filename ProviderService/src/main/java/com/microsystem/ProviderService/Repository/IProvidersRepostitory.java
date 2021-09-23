package com.microsystem.ProviderService.Repository;

import com.microsystem.ProviderService.Model.Provider;
import org.springframework.data.repository.CrudRepository;

public interface IProvidersRepostitory extends CrudRepository<Provider, Integer> {
}
