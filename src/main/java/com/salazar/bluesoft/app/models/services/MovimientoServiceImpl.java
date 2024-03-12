package com.salazar.bluesoft.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salazar.bluesoft.app.models.entities.Movimiento;
import com.salazar.bluesoft.app.models.repositories.IMovimientoDao;

@Service
public class MovimientoServiceImpl implements IMovimientoService {

	@Autowired
	private IMovimientoDao movimientoDao;

	@Override
	public Movimiento crear(Movimiento movimiento) {
		return movimientoDao.save(movimiento);
	}

	@Override
	public List<Movimiento> obtenerMovimientosPorMes(Long idCuenta, int mes) {
		return movimientoDao.obtenerMovimientosPorMes(idCuenta, mes);
	}

	@Override
	public List<Object[]> listarClientesPorTransacciones(int mes) {
		// TODO Auto-generated method stub
		return movimientoDao.listarClientesConTransacciones(mes);
	}

}
