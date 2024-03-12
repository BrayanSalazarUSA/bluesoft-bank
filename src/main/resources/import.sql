-- Insertar datos de prueba para la tabla 'clientes'
INSERT INTO clientes (nombre, apellido, ciudad) VALUES ('Juan', 'Pérez', 'Bogotá');
INSERT INTO clientes (nombre, apellido, ciudad) VALUES ('María', 'López', 'Medellín');
INSERT INTO clientes (nombre, apellido, ciudad) VALUES ('Carlos', 'Gómez', 'Cali');

-- Insertar datos de prueba para la tabla 'cuentas'
INSERT INTO cuentas (tipo, saldo, cliente_id) VALUES ('Ahorros', 1000.00, 1);
INSERT INTO cuentas (tipo, saldo, cliente_id) VALUES ('Corriente', 500.00, 2);
INSERT INTO cuentas (tipo, saldo, cliente_id) VALUES ('Ahorros', 1500.00, 3);

-- Insertar datos de prueba para la tabla 'transacciones'
INSERT INTO transacciones (tipo, monto, fecha, cuenta_id) VALUES ('CONSIGNACION', 200.00, '2024-01-01', 1);
INSERT INTO transacciones (tipo, monto, fecha, cuenta_id) VALUES ('RETIRO', 50.00, '2024-01-02', 2);
INSERT INTO transacciones (tipo, monto, fecha, cuenta_id) VALUES ('CONSIGNACION', 300.00, '2024-01-03', 3);
INSERT INTO transacciones (tipo, monto, fecha, cuenta_id) VALUES ('RETIRO', 100.00, '2024-01-04', 1);

