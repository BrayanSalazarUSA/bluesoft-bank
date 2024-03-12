package com.salazar.bluesoft.app.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salazar.bluesoft.app.models.entities.Movimiento;

@Repository
public interface IMovimientoDao extends CrudRepository<Movimiento, Long> {

	@Query("SELECT m from Movimiento m WHERE m.cuenta.id = :idCuenta AND MONTH(m.fecha) = :mes")
	List<Movimiento> obtenerMovimientosPorMes(@Param("idCuenta") Long idCuenta, @Param("mes") int mes);

	@Query("SELECT m.cuenta.cliente, COUNT(m) as numTransacciones " + "FROM Movimiento m "
			+ "WHERE MONTH(m.fecha) = :mes " + "GROUP BY m.cuenta.cliente, m.cuenta.id " + // Agrega m.cuenta.id a GROUP
																							// BY
			"ORDER BY numTransacciones DESC")
	List<Object[]> listarClientesConTransacciones(@Param("mes") int mes);

}
