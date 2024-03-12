package com.salazar.bluesoft.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salazar.bluesoft.app.models.entities.Cliente;
import com.salazar.bluesoft.app.models.repositories.IClienteDao;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;

	@Autowired
	private IMovimientoService movimientosService;

	@Override
	public Cliente crear(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	public void eliminar(Long id) {
		clienteDao.deleteById(id);

	}

	@Override
	public Iterable<Cliente> listar() {
		// TODO Auto-generated method stub
		return clienteDao.findAll();
	}

	@Override
	public List<Object[]> listarClientesPorTransacciones(int mes) {

		return movimientosService.listarClientesPorTransacciones(mes);
	}

}
