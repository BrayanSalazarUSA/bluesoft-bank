package com.salazar.bluesoft.app.models.services;

import com.salazar.bluesoft.app.models.entities.Cliente;
import com.salazar.bluesoft.app.models.repositories.IClienteDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceImplTest {

    @Mock
    private IClienteDao clienteDao;

    @Mock
    private IMovimientoService movimientosService;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Test
    void crear() {
        // Configuración del mock
        Cliente clienteMock = new Cliente();
        when(clienteDao.save(any())).thenReturn(clienteMock);

        // Llamada al método y verificación
        Cliente nuevoCliente = new Cliente();
        Cliente resultado = clienteService.crear(nuevoCliente);
        assertNotNull(resultado);
        assertEquals(clienteMock, resultado);
        verify(clienteDao, times(1)).save(any());
    }

    @Test
    void eliminar() {
        // Llamada al método y verificación
        clienteService.eliminar(1L);
        verify(clienteDao, times(1)).deleteById(1L);
    }

    @Test
    void listar() {
        // Configuración del mock
        List<Cliente> clientesMock = new ArrayList<>();
        when(clienteDao.findAll()).thenReturn(clientesMock);

        // Llamada al método y verificación
        Iterable<Cliente> result = clienteService.listar();
        assertNotNull(result);
        assertEquals(clientesMock, result);
    }

    @Test
    void listarClientesPorTransacciones() {
        // Configuración del mock
        List<Object[]> clientesTransaccionesMock = new ArrayList<>();
        when(movimientosService.listarClientesPorTransacciones(1)).thenReturn(clientesTransaccionesMock);

        // Llamada al método y verificación
        List<Object[]> result = clienteService.listarClientesPorTransacciones(1);
        assertNotNull(result);
        assertEquals(clientesTransaccionesMock, result);
    }
}