package com.microsystem.TouristService.Repository;

import com.microsystem.TouristService.Model.Tourist;
import org.springframework.data.repository.CrudRepository;

public interface ITouristRepository extends CrudRepository<Tourist,Integer> {

    public Tourist findTouristByUsername(String username);
}
