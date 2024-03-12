package com.salazar.bluesoft.app.models.services;

import java.math.BigDecimal;
import java.util.Optional;

import com.salazar.bluesoft.app.models.entities.Cuenta;
import com.salazar.bluesoft.app.models.entities.Movimiento;

public interface ICuentaService {

	Iterable<Cuenta> listar();

	Optional<Cuenta> buscarPorId(Long id);

	Cuenta crear(Cuenta cuenta);

	void eliminar(Long id);

	BigDecimal consultarSaldo(Long idCuenta);

	Iterable<Movimiento> consultarMovimientosRecientes(Long idCuenta);

	void consignar(Long idCuenta, BigDecimal monto, String ciudad);

	void retirar(Long idCuenta, BigDecimal monto, String ciudad);

	Iterable<Movimiento> extractoMensual(Long idCuenta, int mes);
}
