-- Elimina la base de datos si existe
DROP DATABASE IF EXISTS electrishop;

-- Crea la base de datos
CREATE DATABASE electrishop;

-- Usa la base de datos
USE electrishop;

--          TABLAS PRIMARIAS          --

-- Tabla categorias
CREATE TABLE categorias (
  id_categoria INT PRIMARY KEY AUTO_INCREMENT,
  nombre_categoria VARCHAR(50) NOT NULL
);

-- Tabla clientes
CREATE TABLE clientes (
  id_cliente INT PRIMARY KEY AUTO_INCREMENT,
  nombre_cliente VARCHAR(60) NOT NULL,
  apellido_cliente VARCHAR(60) NOT NULL,
  email_cliente VARCHAR(100) NOT NULL,
  telefono_cliente DECIMAL(10,0) NOT NULL,
  direccion_cliente TEXT
);

-- Tabla proveedores
CREATE TABLE proveedores (
  id_proveedor INT PRIMARY KEY AUTO_INCREMENT,
  nombre_proveedor VARCHAR(60) NOT NULL,
  apellido_proveedor VARCHAR(60) NOT NULL,
  email_proveedor VARCHAR(100) NOT NULL,
  telefono_proveedor DECIMAL(10,0) NOT NULL,
  direccion_proveedor TEXT
);


--          TABLAS SECUNDARIAS          --



-- Tabla productos
CREATE TABLE productos (
  id_producto INT PRIMARY KEY AUTO_INCREMENT,
  nombre_producto VARCHAR(100) NOT NULL,
  descripcion_producto TEXT,
  precio_producto DECIMAL(10, 2) NOT NULL,
  id_categoria INT,
  FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria)
);

-- Tabla compras
CREATE TABLE compra (
  id_compra INT PRIMARY KEY AUTO_INCREMENT,
  id_proveedor INT,
  fecha_compra DATE,
  precio_compra INT,
  FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)
);

-- Tabla detalles compra
CREATE TABLE detalles_compra (
  id_detalles_compra INT PRIMARY KEY AUTO_INCREMENT,
  id_compra INT,
  id_producto INT, 
  nombre_compra VARCHAR(50),
  detalles VARCHAR(100),
  cantidad INT,
  precio_unidad INT,
  FOREIGN KEY (id_compra) REFERENCES compra(id_compra),
  FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Tabla inventario
CREATE TABLE inventario (
  id_inventario INT PRIMARY KEY AUTO_INCREMENT,
  id_producto INT,
  cantidad_inventario INT NOT NULL,
  fecha_ingreso DATETIME,
  fecha_actualizacion DATETIME,
  FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Tabla ventas
CREATE TABLE ventas (
  id_venta INT PRIMARY KEY AUTO_INCREMENT,
  id_cliente INT,
  fecha_venta DATETIME NOT NULL,
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

-- Tabla detalles_ventas
CREATE TABLE detalles_ventas (
  id_detalle_venta INT PRIMARY KEY AUTO_INCREMENT,
  id_venta INT,
  id_producto INT,
  cantidad_productos INT,
  subprecio DECIMAL(10, 2) NOT NULL,
  descuento INT DEFAULT 0,
  total DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (id_venta) REFERENCES ventas(id_venta),
  FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Tabla pedidos
CREATE TABLE pedidos (
  id_pedido INT PRIMARY KEY AUTO_INCREMENT,
  id_cliente INT,
  fecha_pedido DATETIME NOT NULL,
  estado_pedido VARCHAR(20) NOT NULL,
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

-- Tabla detalles_pedidos
CREATE TABLE detalles_pedidos (
  id_detalle_pedido INT PRIMARY KEY AUTO_INCREMENT,
  id_pedido INT,
  id_producto INT,
  cantidad_detalle_pedido INT NOT NULL,
  descuento INT DEFAULT 0,
  precio_detalle_pedido DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
  FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);
