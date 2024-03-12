package com.salazar.bluesoft.app.models.services;

import java.util.List;

import com.salazar.bluesoft.app.models.entities.Cliente;
import com.salazar.bluesoft.app.models.entities.Movimiento;

public interface IClienteService {

	Iterable<Cliente> listar();

	Cliente crear(Cliente cliente);

	void eliminar(Long id);

	List<Object[]> listarClientesPorTransacciones(int mes);
}
