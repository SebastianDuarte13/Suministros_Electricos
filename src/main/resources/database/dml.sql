-- Inserta datos en la tabla categorias
INSERT INTO categorias (nombre_categoria) VALUES
('Cables'),
('Interruptores');

-- Inserta datos en la tabla clientes
INSERT INTO clientes (nombre_cliente, apellido_cliente, email_cliente, telefono_cliente, direccion_cliente) VALUES
('Samuel', 'Orpina', 'samuel.orpina@example.com', 3123456789, 'Carrera 7 # 123, Bogotá'),
('Valeria', 'Ortiz', 'valeria.ortiz@example.com', 3134567890, 'Avenida 19 # 456, Medellín');

-- Inserta datos en la tabla proveedores
INSERT INTO proveedores (nombre_proveedor, apellido_proveedor, email_proveedor, telefono_proveedor, direccion_proveedor) VALUES
('Pedro', 'López', 'pedro.lopez@proveedor.com', 3205678901, 'Calle Proveedor 1, Bogotá'),
('Ana', 'Martínez', 'ana.martinez@proveedor.com', 3216789012, 'Avenida Proveedor 2, Medellín');

-- Inserta datos en la tabla productos
INSERT INTO productos (nombre_producto, descripcion_producto, precio_producto, id_categoria) VALUES
('Cable de Energía', 'Cable de energía eléctrica de 2x2.5mm²', 200000.00, 1),
('Interruptor de Luz', 'Interruptor de luz de 1 vía', 40000.00, 2);

-- Inserta datos en la tabla compra
INSERT INTO compra (id_proveedor, fecha_compra, precio_compra) VALUES
(1, '2024-09-01', 800000.00),
(2, '2024-09-02', 600000.00);

-- Inserta datos en la tabla detalles_compra
INSERT INTO detalles_compra (id_compra, id_producto, nombre_compra, detalles, cantidad, precio_unidad) VALUES
(1, 1, 'Compra de Cables', 'Compra de cables de energía', 100, 200000.00),
(2, 2, 'Compra de Interruptores', 'Compra de interruptores de luz', 50, 40000.00);

-- Inserta datos en la tabla inventario
INSERT INTO inventario (id_producto, cantidad_inventario, fecha_ingreso, fecha_actualizacion) VALUES
(1, 100, '2024-09-01 10:00:00', '2024-09-01 10:00:00'),
(2, 50, '2024-09-02 11:00:00', '2024-09-02 11:00:00');

-- Inserta datos en la tabla ventas
INSERT INTO ventas (id_cliente, fecha_venta) VALUES
(1, '2024-09-03 15:00:00'),
(2, '2024-09-04 16:00:00');

-- Inserta datos en la tabla detalles_ventas
INSERT INTO detalles_ventas (id_venta, id_producto, cantidad_productos, subprecio, descuento, total) VALUES
(1, 1, 10, 2000000.00, 0, 2000000.00),
(2, 2, 5, 200000.00, 0, 200000.00);

-- Inserta datos en la tabla pedidos
INSERT INTO pedidos (id_cliente, fecha_pedido, estado_pedido) VALUES
(1, '2024-09-05 10:00:00', 'Enviado'),
(2, '2024-09-06 11:00:00', 'Pendiente');

-- Inserta datos en la tabla detalles_pedidos
INSERT INTO detalles_pedidos (id_pedido, id_producto, cantidad_detalle_pedido, descuento, precio_detalle_pedido) VALUES
(1, 1, 20, 0, 200000.00),
(2, 2, 10, 0, 40000.00);
