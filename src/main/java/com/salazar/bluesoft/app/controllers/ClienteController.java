package com.salazar.bluesoft.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salazar.bluesoft.app.models.entities.Cliente;
import com.salazar.bluesoft.app.models.services.IClienteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> listar() {

		return ResponseEntity.ok((List<Cliente>) clienteService.listar());
	}

	@GetMapping("/clientes/transacciones/{mes}")
	private ResponseEntity<?> listarClientesPorNumTransaccion(@PathVariable int mes) {
		List<Object[]> clientes = clienteService.listarClientesPorTransacciones(mes);
		return ResponseEntity.ok(clientes);
	}

	/*
	 * @GetMapping("/retiros-fuera-ciudad") private ResponseEntity<?>
	 * listarClientesPorRetirosFueraCiudad() { List<Object[]> clientes =
	 * clienteService.listarClientesRetirosFueraCiudad(); return
	 * ResponseEntity.ok(clientes); }
	 */
}
