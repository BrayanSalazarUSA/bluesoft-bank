package com.salazar.bluesoft.app.models.services;

import com.salazar.bluesoft.app.models.entities.Cuenta;
import com.salazar.bluesoft.app.models.entities.Movimiento;
import com.salazar.bluesoft.app.models.repositories.ICuentaDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CuentaServiceImplTest {

    @Mock
    private ICuentaDao cuentaDao;

    @InjectMocks
    private CuentaServiceImpl cuentaService;
    @Test
    void consultarSaldo() {
        // Configuración del mock
        Cuenta cuentaMock = new Cuenta();
        cuentaMock.setSaldo(BigDecimal.valueOf(1000));
        when(cuentaDao.findById(1L)).thenReturn(Optional.of(cuentaMock));

        // Llamada al método y verificación
        BigDecimal saldo = cuentaService.consultarSaldo(1L);
        assertEquals(BigDecimal.valueOf(1000), saldo);
    }

    @Test
    void consultarMovimientosRecientes() {
        // Configuración del mock
        Cuenta cuentaMock = new Cuenta();
        cuentaMock.setIdCuenta(1L);
        cuentaMock.setSaldo(BigDecimal.valueOf(1000));
        Movimiento movimiento1 = new Movimiento(BigDecimal.valueOf(500), LocalDateTime.now(), "CONSIGNACION", cuentaMock, "Bogotá");
        Movimiento movimiento2 = new Movimiento(BigDecimal.valueOf(200), LocalDateTime.now(), "RETIRO", cuentaMock, "Medellín");
        cuentaMock.getMovimientos().add(movimiento1);
        cuentaMock.getMovimientos().add(movimiento2);

        when(cuentaDao.findById(1L)).thenReturn(Optional.of(cuentaMock));

        // Llamada al método y verificación
        Iterable<Movimiento> movimientos = cuentaService.consultarMovimientosRecientes(1L);
        assertNotNull(movimientos);
        // Puedes agregar más verificaciones según tus necesidades
    }

    @Test
    void crear() {
        // Configuración del mock
        Cuenta cuentaMock = new Cuenta();
        when(cuentaDao.save(any())).thenReturn(cuentaMock);

        // Llamada al método y verificación
        Cuenta nuevaCuenta = new Cuenta();
        Cuenta resultado = cuentaService.crear(nuevaCuenta);
        assertNotNull(resultado);
        assertEquals(cuentaMock, resultado);
        verify(cuentaDao, times(1)).save(any());
    }

    @Test
    void eliminar() {
        // Llamada al método y verificación
        cuentaService.eliminar(1L);
        verify(cuentaDao, times(1)).deleteById(1L);
    }

    @Test
    void listar() {
        // Configuración del mock
        List<Cuenta> cuentasMock = new ArrayList<>();
        when(cuentaDao.findAll()).thenReturn(cuentasMock);

        // Llamada al método y verificación
        Iterable<Cuenta> result = cuentaService.listar();
        assertNotNull(result);
        assertEquals(cuentasMock, result);
    }

    @Test
    void buscarPorId() {
        // Configuración del mock
        Cuenta cuentaMock = new Cuenta();
        when(cuentaDao.findById(1L)).thenReturn(Optional.of(cuentaMock));

        // Llamada al método y verificación
        Optional<Cuenta> result = cuentaService.buscarPorId(1L);
        assertTrue(result.isPresent());
        assertEquals(cuentaMock, result.get());
    }

}