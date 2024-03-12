package com.salazar.bluesoft.app.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.salazar.bluesoft.app.models.entities.Cuenta;
import com.salazar.bluesoft.app.models.entities.Movimiento;

@Repository
public interface ICuentaDao extends CrudRepository<Cuenta, Long> {

}
