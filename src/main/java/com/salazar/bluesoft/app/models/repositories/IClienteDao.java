package com.salazar.bluesoft.app.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.salazar.bluesoft.app.models.entities.Cliente;

@Repository
public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
