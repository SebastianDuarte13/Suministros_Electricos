-- Tabla categorias
CREATE TABLE categorias (
  id_categoria INT PRIMARY KEY,
  nombre_categoria VARCHAR(50) NOT NULL
);

-- Tabla productos
CREATE TABLE productos (
  id_producto INT PRIMARY KEY,
  nombre_producto VARCHAR(100) NOT NULL,
  descripcion_producto TEXT,
  precio_producto DECIMAL(10, 2) NOT NULL,
  id_categoria INT,
  FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria)
);

-- Tabla inventario
CREATE TABLE inventario (
  id_inventario INT PRIMARY KEY,
  id_producto INT,
  cantidad_inventario INT NOT NULL,
  fecha_ultimo_ingreso DATETIME,
  fecha_ultimo_egreso DATETIME,
  FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Tabla clientes
CREATE TABLE clientes (
  id_cliente INT PRIMARY KEY,
  nombre_cliente VARCHAR(100) NOT NULL,
  apellido_cliente VARCHAR(100) NOT NULL,
  email_cliente VARCHAR(100) NOT NULL,
  telefono_cliente VARCHAR(20) NOT NULL,
  direccion_cliente TEXT
);

-- Tabla ventas
CREATE TABLE ventas (
  id_venta INT PRIMARY KEY,
  id_cliente INT,
  fecha_venta DATETIME NOT NULL,
  total_venta DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

-- Tabla detalles_ventas
CREATE TABLE detalles_ventas (
  id_detalle_venta INT PRIMARY KEY,
  id_venta INT,
  id_producto INT,
  cantidad_detalle_venta INT NOT NULL,
  precio_detalle_venta DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (id_venta) REFERENCES ventas(id_venta),
  FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Tabla pedidos
CREATE TABLE pedidos (
  id_pedido INT PRIMARY KEY,
  id_cliente INT,
  fecha_pedido DATETIME NOT NULL,
  estado_pedido VARCHAR(20) NOT NULL,
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

-- Tabla detalles_pedidos
CREATE TABLE detalles_pedidos (
  id_detalle_pedido INT PRIMARY KEY,
  id_pedido INT,
  id_producto INT,
  cantidad_detalle_pedido INT NOT NULL,
  precio_detalle_pedido DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
  FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);