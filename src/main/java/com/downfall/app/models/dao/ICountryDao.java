package com.downfall.app.models.dao;
import org.springframework.data.repository.CrudRepository;

import com.downfall.app.models.entity.Country;

public interface ICountryDao extends CrudRepository<Country, Long> {

}
