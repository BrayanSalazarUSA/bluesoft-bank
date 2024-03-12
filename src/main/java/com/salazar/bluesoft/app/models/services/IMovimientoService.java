package com.salazar.bluesoft.app.models.services;

import java.util.List;

import com.salazar.bluesoft.app.models.entities.Movimiento;

public interface IMovimientoService {

	Movimiento crear(Movimiento movimiento);

	List<Movimiento> obtenerMovimientosPorMes(Long idCuenta, int mes);

	List<Object[]> listarClientesPorTransacciones(int mes);

}
