package com.salazar.bluesoft.app.models.services;

import com.salazar.bluesoft.app.models.entities.Movimiento;
import com.salazar.bluesoft.app.models.repositories.IMovimientoDao;
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
class MovimientoServiceImplTest {

    @Mock
    private IMovimientoDao movimientoDao;

    @InjectMocks
    private MovimientoServiceImpl movimientoService;

    @Test
    void crear() {
        // Configuración del mock
        Movimiento movimientoMock = new Movimiento();
        when(movimientoDao.save(any())).thenReturn(movimientoMock);

        // Llamada al método y verificación
        Movimiento nuevoMovimiento = new Movimiento();
        Movimiento resultado = movimientoService.crear(nuevoMovimiento);
        assertNotNull(resultado);
        assertEquals(movimientoMock, resultado);
        verify(movimientoDao, times(1)).save(any());
    }

    @Test
    void obtenerMovimientosPorMes() {
        // Configuración del mock
        List<Movimiento> movimientosMock = new ArrayList<>();
        when(movimientoDao.obtenerMovimientosPorMes(1L, 3)).thenReturn(movimientosMock);

        // Llamada al método y verificación
        List<Movimiento> result = movimientoService.obtenerMovimientosPorMes(1L, 3);
        assertNotNull(result);
        assertEquals(movimientosMock, result);
        verify(movimientoDao, times(1)).obtenerMovimientosPorMes(1L, 3);
    }

    @Test
    void listarClientesPorTransacciones() {
        // Configuración del mock
        List<Object[]> clientesTransaccionesMock = new ArrayList<>();
        when(movimientoDao.listarClientesConTransacciones(2)).thenReturn(clientesTransaccionesMock);

        // Llamada al método y verificación
        List<Object[]> result = movimientoService.listarClientesPorTransacciones(2);
        assertNotNull(result);
        assertEquals(clientesTransaccionesMock, result);
        verify(movimientoDao, times(1)).listarClientesConTransacciones(2);
    }
}