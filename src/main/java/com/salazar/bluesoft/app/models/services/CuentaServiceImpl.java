package com.salazar.bluesoft.app.models.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salazar.bluesoft.app.models.entities.Cuenta;
import com.salazar.bluesoft.app.models.entities.Movimiento;
import com.salazar.bluesoft.app.models.repositories.ICuentaDao;
import com.salazar.bluesoft.app.models.repositories.IMovimientoDao;

@Service
public class CuentaServiceImpl implements ICuentaService {

	@Autowired
	private IMovimientoDao movimientoDao;

	@Autowired
	private ICuentaDao cuentaDao;

	@Override
	public Cuenta crear(Cuenta cuenta) {

		return cuentaDao.save(cuenta);
	}

	@Override
	public void eliminar(Long id) {
		cuentaDao.deleteById(id);
	}

	@Override
	public Iterable<Cuenta> listar() {
		// TODO Auto-generated method stub
		return cuentaDao.findAll();
	}

	@Override
	public Optional<Cuenta> buscarPorId(Long id) {

		return cuentaDao.findById(id);
	}

	@Override
	public BigDecimal consultarSaldo(Long idCuenta) {

		Optional<Cuenta> cuenta = buscarPorId(idCuenta);

		return cuenta.get().getSaldo();
	}

	@Override
	public Iterable<Movimiento> consultarMovimientosRecientes(Long idCuenta) {
		Cuenta cuenta = buscarPorId(idCuenta).orElseThrow(() -> new RuntimeException("Cuenta encontrada"));
		return cuenta.getMovimientos();
	}

	@Override
	public void consignar(Long idCuenta, BigDecimal monto, String ciudad) {

		Cuenta cuenta = buscarPorId(idCuenta).orElseThrow(() -> new RuntimeException("Cuenta encontrada"));
		cuenta.setSaldo(cuenta.getSaldo().add(monto));

		Movimiento movimiento = new Movimiento(monto, LocalDateTime.now(), "CONSIGNACION", cuenta, ciudad);
		movimientoDao.save(movimiento);
		cuentaDao.save(cuenta);
	}

	@Override
	public void retirar(Long idCuenta, BigDecimal monto, String ciudad) {
		Cuenta cuenta = buscarPorId(idCuenta).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

		if (cuenta.getSaldo().compareTo(monto) < 0) {
			throw new RuntimeException("Saldo insuficiente para realizar el retiro");
		}
		Movimiento movimiento = new Movimiento(monto, LocalDateTime.now(), "RETIRO", cuenta, ciudad);
		cuenta.setSaldo(cuenta.getSaldo().subtract(monto));
		movimientoDao.save(movimiento);
		cuentaDao.save(cuenta);

	}

	@Override
	public Iterable<Movimiento> extractoMensual(Long idCuenta, int mes) {
		Cuenta cuenta = buscarPorId(idCuenta).orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));

		return movimientoDao.obtenerMovimientosPorMes(idCuenta, mes);
	}

}
