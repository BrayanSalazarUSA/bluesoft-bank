package com.salazar.bluesoft.app.models.entities;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movimientos")
public class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal monto;

	private LocalDateTime fecha;

	private String tipo;

	private String ciudadMovimiento;

	@ManyToOne
	@JoinColumn(name = "cuenta_id")
	private Cuenta cuenta;

	public Movimiento() {

	}

	public Movimiento(BigDecimal monto, LocalDateTime fecha, String tipo, Cuenta cuenta, String ciudad) {
		this.monto = monto;
		this.fecha = fecha;
		this.tipo = tipo;
		this.cuenta = cuenta;
		this.ciudadMovimiento = ciudad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCiudadMovimiento() {
		return ciudadMovimiento;
	}

	public void setCiudadMovimiento(String ciudadMovimiento) {
		this.ciudadMovimiento = ciudadMovimiento;
	}

}
