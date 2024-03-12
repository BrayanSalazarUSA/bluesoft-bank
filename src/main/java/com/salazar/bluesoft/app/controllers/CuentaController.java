package com.salazar.bluesoft.app.controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.salazar.bluesoft.app.models.entities.Cuenta;
import com.salazar.bluesoft.app.models.entities.Movimiento;

import com.salazar.bluesoft.app.models.services.ICuentaService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CuentaController {

	@Autowired
	private ICuentaService cuentaService;;

	@GetMapping("/cuentas")
	public ResponseEntity<List<Cuenta>> listar() {

		List<Cuenta> cuentas = (List<Cuenta>) cuentaService.listar();

		return ResponseEntity.ok(cuentas);
	}

	@GetMapping("/cuentas/{idCuenta}/saldo")
	public ResponseEntity<?> consultarSaldo(@PathVariable Long idCuenta) {

		BigDecimal saldo = cuentaService.consultarSaldo(idCuenta);
		return ResponseEntity.ok(saldo);
	}

	@GetMapping("/cuentas/{idCuenta}/movimientos")
	public ResponseEntity<?> consultarMovimientos(@PathVariable Long idCuenta) {

		List<Movimiento> movimientos = (List<Movimiento>) cuentaService.consultarMovimientosRecientes(idCuenta);
		return ResponseEntity.ok(movimientos);
	}

	@GetMapping("/cuentas/{idCuenta}/extractos/{mes}")
	public ResponseEntity<?> generarExtractoPorMes(@PathVariable Long idCuenta, @PathVariable int mes) {
		List<Movimiento> reporteMensual = (List<Movimiento>) cuentaService.extractoMensual(idCuenta, mes);
		return ResponseEntity.ok(reporteMensual);
	}

	@PostMapping("/cuentas/consignar")
	public ResponseEntity<String> consignar(
            @RequestParam Long cuentaId,
            @RequestParam @Valid @Min(value = 1, message = "El monto debe ser mayor que cero") BigDecimal monto,
            @RequestParam @NotBlank(message = "La ciudad no puede estar vacía") String ciudad) {
		cuentaService.consignar(cuentaId, monto, ciudad);
		return ResponseEntity.ok("Consignación exitosa");
	}

	@PostMapping("/cuentas/retirar")
	public ResponseEntity<String> retirar(
            @RequestParam Long cuentaId,
            @RequestParam @Valid @Min(value = 1, message = "El monto debe ser mayor que cero") BigDecimal monto,
            @RequestParam @NotBlank(message = "La ciudad no puede estar vacía") String ciudad) {
		cuentaService.retirar(cuentaId, monto, ciudad);
		return ResponseEntity.ok("Retiro exitoso");
	}

}
