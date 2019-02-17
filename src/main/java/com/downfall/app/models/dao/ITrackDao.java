package com.downfall.app.models.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.downfall.app.models.entity.Track;

// Se utiliza JPARepository para poder paginar los resultados, incluye todos los metodos de crudrepository
// Se reemplazó CrudRepository por JpaRepository
public interface ITrackDao extends JpaRepository<Track, Long>{

}
